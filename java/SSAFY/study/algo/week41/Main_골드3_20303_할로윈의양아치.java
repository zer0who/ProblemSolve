package SSAFY.study.algo.week41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_골드3_20303_할로윈의양아치 {


    static int N, M, K; // N: 거리의 아이들 수, M: 주어지는 친구 관계 수, K: 어른들한테 들키는 임계값
    static int[] initCandies;   // 최초 입력 받은 각 어린이 별 사탕 개수
    static int[] captains;   // 각 어린이들의 대장 친구(union의 부모 값)를 저장
    static int[] friendCounts;  // 각 학생들의 친구 수 저장용 배열


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
        friendCounts = new int[N+1];
        for (int i = 1; i < N+1; i++) { // 초기 대장 친구는 자기 자신, 친구 수는 자기 자신만 있으므로 1
            captains[i] = i;
            friendCounts[i] = 1;
        }
        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            union(from, to);
            friendCounts[captains[from]]++; // 각 어린이들의 대장 친구에 친구 수 +1
        }
    }

    static int find(int a) {
        if (captains[a] == a) return a;

        return captains[a] = find(captains[a]);
    }

    static boolean union(int a, int b) {
        int captainA = find(a);
        int captainB = find(b);

        if (captainA == captainB) return false;

        if (captainA < captainB) captains[captainB] = captainA;
        else captains[captainA] = captainB;

        return true;
    }

    static void halloween() {
        int[] dpArr = new int[N+1];
        for (int i = 1; i < N+1; i++) dpArr[captains[i]] += initCandies[i]; // 우선 대장 친구에게 모든 사탕개수 다 저장함
        for (int i = 1; i < N+1; i++) if (i != captains[i]) dpArr[i] = dpArr[captains[i]];  // 그 후 그의 친구들에게도 사탕 개수 저장

    }

}
