package BOJ.SAMSUNG_KICHOOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_실버3_14501_퇴사 {

    static int N;
    static int[][] counsels;

    public static void main(String[] args) throws IOException {
        init();
        calcBest();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        counsels = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            counsels[i][0] = Integer.parseInt(st.nextToken());
            counsels[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void calcBest() {
        int[] dp = new int[N+1];

        int time, cost; // time: 걸리는 시간, cost: 버는 비용
        for (int i = 0; i < N; i++) {
            time = counsels[i][0];
            cost = counsels[i][1];
            if (i + time <= N) dp[i+time] = Math.max(dp[i+time], dp[i] + cost);; // 상담 종료일이 남은 근무일을 넘기지 않는 경우 최댓값 갱신
            dp[i+1] = Math.max(dp[i+1], dp[i]); // 상담 종료일이 남은 근무일을 넘긴 경우에도, 이전 상담을 통해 번 최댓값은 유지되게 해야 함.
        }
        System.out.println(dp[N]);
    }

}
