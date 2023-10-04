package BOJ.class3p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_실버2_11724_연결요소의개수 {

    static int N, M;
    static int[][] nodes;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        init();
        int answer = 0;
        for (int i = 1; i < N+1; i++) {
            if (visited[i] == 0) {
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void init() throws IOException {
        nodes = new int[1001][1001];
        visited = new int[1001];    // 노트 방문 시 9로 수정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            nodes[first][second] = 1;
            nodes[second][first] = 1;
        }
    }

    static void dfs(int nodeNum) {
        if (visited[nodeNum] == 9) return;  // 새로운 곳으로 연결되는 것이 아니라면 함수 종료

        visited[nodeNum] = 9;
        for (int i = 1; i < N+1; i++) {
            if (nodes[nodeNum][i] == 1) {   // 연결된 정점으로 이동
                dfs(i);
            }
        }
    }

}
