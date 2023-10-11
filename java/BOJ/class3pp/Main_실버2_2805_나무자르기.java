package BOJ.class3pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_실버2_2805_나무자르기 {

    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findHighest());
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
    }

    static int findHighest() {
        int answer = 0;
        int max = trees[N-1];   // 상한선
        int min = 0;    // 하한선
        while (min < max) {
            int mid = (max + min) / 2;  // 자를 나무의 높이
            long getTree = 0;   // 나무 높이가 10억까지이므로, 오버플로우 방지하기 위해 long 타입 선언
            for (int i = 0; i < N; i++) {
                if (trees[i] < mid) continue;   // 자르는 높이보다 낮은 나무는 건너 뜀
                getTree += (trees[i] - mid);
            }
            if (getTree < M) max = mid; // 더 적게 얻었다면, 자르는 높이가 높은 것이므로 자르는 높이를 낮춰줌
            else min = mid+1; // 더 많이 얻었다면 자르는 높이가 낮은 것이므로 자르는 높이 높여줌(시작 값을 중간값 +1로 해야 탐색에 용이)
            answer = min;
        }

        return answer-1;    // 원하는 값이 최소값인데 upper bound 형식이므로, min 값이 항상 +1 된 채로 저장돼있음 그러므로 -1해줌
    }

}