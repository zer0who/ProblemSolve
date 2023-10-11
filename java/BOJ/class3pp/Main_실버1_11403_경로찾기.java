package BOJ.class3pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_실버1_11403_경로찾기 {

    static int N;
    static int[][] adj;
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < N; i++) {   // i에서 j로 가는 경우
            for (int j = 0; j < N; j++) {
                dfs(i, i, j, 0, new boolean[N]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        answer = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void dfs(int origin, int from, int to, int dist, boolean[] isVisited) {    // from 에서 to로 가는 경우
        if (from == to && dist != 0) {  // 도착했고, 걸린 거리가 0 이상이면
            answer[origin][to] = 1;

            return;
        }

        for (int i = 0; i < adj[from].length; i++) {
            if (adj[from][i] == 1 && !isVisited[i]) {
                isVisited[i] = true;
                dfs(origin, i, to, dist+1, isVisited);
            }
        }
    }

}
