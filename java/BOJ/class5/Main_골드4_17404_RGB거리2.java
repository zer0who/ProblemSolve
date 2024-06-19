package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_골드4_17404_RGB거리2 {

    static int INF = 10_000_000;
    static int N;
    static int[][] inputCosts;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputCosts = new int[1001][3];
        StringTokenizer st;
        int r, g, b;
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) inputCosts[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int answer = Integer.MAX_VALUE;
        int[][] cost;
        for (int i = 0; i < 3; i++) {   // 첫 번째 집을 r, g, b로 칠하는 경우를 나누기
            cost = new int[1001][3];
            cost[1][i] = inputCosts[1][i];
            for (int j = 0; j < 3; j++) if (j != i) cost[1][j] = INF;   // 첫 번째 집의 r, g, b 중 선택받지 못한 색상에 대한 값은 INF로 초기화

            for (int j = 2; j < N+1; j++) {
                cost[j][0] = Math.min(cost[j-1][1], cost[j-1][2]) + inputCosts[j][0];
                cost[j][1] = Math.min(cost[j-1][0], cost[j-1][2]) + inputCosts[j][1];
                cost[j][2] = Math.min(cost[j-1][0], cost[j-1][1]) + inputCosts[j][2];
            }
            cost[N][i] = INF;
            Arrays.sort(cost[N]);
            answer = Math.min(answer, cost[N][0]);
        }
        System.out.println(answer);
    }

}
