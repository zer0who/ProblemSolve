package BOJ.class4p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_골드4_11404_플로이드_플로이드워셜 {

    static int INF = 1_000_000_000;
    static int n, m;
    static int[][] adjList;

    public static void main(String[] args) throws IOException {
        init();
        floydWarshal();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (adjList[i][j] == INF) sb.append(0).append(" ");  // 갈 수 없는 경우 0으로 출력
                else sb.append(adjList[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adjList = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (i != j) adjList[i][j] = INF; // 자기 자신으로 가는 경우는 0으로 놔둠, 플로이드 워셜의 경우 오버플로우 방지를 위해 최댓값을 적절히 설정해야함.
            }
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[from][to] = Math.min(adjList[from][to], cost);
        }
    }

    private static void floydWarshal() {
        for (int k = 1; k < n+1; k++) { // 경유지
            for (int i = 1; i < n+1; i++) { // 출발점
                for (int j = 1; j < n+1; j++) { // 도착점
                    adjList[i][j] = Math.min(adjList[i][j], adjList[i][k]+adjList[k][j]);
                }
            }
        }
    }

}
