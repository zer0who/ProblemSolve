package SSAFY.study.algo.week41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드3_20303_할로윈의양아치 {

    static int N, M, K; // N: 거리의 아이들 수, M: 주어지는 친구 관계 수, K: 어른들한테 들키는 임계값
    static int[] initCandies;   // 최초 입력 받은 각 어린이 별 사탕 개수
    static int[] captains;   // 각 어린이들의 대장 친구(union의 부모 값)를 저장

    public static void main(String[] args) throws IOException {
        init();
        halloween();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        initCandies = new int[N+1];
        for (int i = 1; i < N+1; i++) initCandies[i] = Integer.parseInt(st.nextToken());

        captains = new int[N+1];
        for (int i = 1; i < N+1; i++) captains[i] = i; // 초기 대장 친구는 자기 자신, 친구 수는 자기 자신만 있으므로 1
        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            union(from, to);    // 입력받으며 각 친구들의 대장 친구를 저장해줌
        }
    }

    static int find(int a) {
        if (captains[a] == a) return a;
        return captains[a] = find(captains[a]);
    }

    static void union(int a, int b) {
        int captainA = find(a);
        int captainB = find(b);
        if (captainA != captainB) {
            captains[captainB] = captainA;
        }
    }

    static void halloween() {
        Map<Integer, Integer> candies = new HashMap<>();
        Map<Integer, Integer> friendCounts = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int root = find(i);
            candies.put(root, candies.getOrDefault(root, 0) + initCandies[i]);
            friendCounts.put(root, friendCounts.getOrDefault(root, 0) + 1);
        }

        List<Integer> candyList = new ArrayList<>(candies.values());
        List<Integer> countList = new ArrayList<>(friendCounts.values());

        int groups = candyList.size();
        int[][] dp = new int[groups + 1][K];

        for (int i = 1; i <= groups; i++) {
            int candy = candyList.get(i - 1);
            int count = countList.get(i - 1);
            for (int j = 0; j < K; j++) {
                if (j < count) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - count] + candy);
                }
            }
        }

        System.out.println(dp[groups][K - 1]);
    }
}
