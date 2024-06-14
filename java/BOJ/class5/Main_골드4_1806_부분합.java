package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_골드4_1806_부분합 {

    static int N, S;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        init();
        calc();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
    }

    static void calc() {
        int left = 0;
        int sum = 0;    // 윈도우 내 숫자들의 합
        int minCount = Integer.MAX_VALUE;
        for (int right = 0; right < N; right++) {   // 슬라이딩 윈도우 적용
            sum += numbers[right];
            while (left < right && sum-numbers[left] >= S) {
                sum -= numbers[left++];
            }
            if (sum >= S) minCount = Math.min(minCount, right-left+1);
        }
        if (minCount == Integer.MAX_VALUE) minCount = 0;
        System.out.println(minCount);
    }

}
