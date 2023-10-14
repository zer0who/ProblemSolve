package SSAFY.study.algo.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_골드4_10159_저울DFS {

    static int INFINITE = 99999;    // 플로이드 워셜에 쓰이며 오버플로우가 안 날만 한 infinite 값 임시 정의
    static int N, M;
    static int[][] adj; // 연결 상태를 나타낼 행렬(행의 물건이 열보다 무겁다고 정의)

    public static void main(String[] args) throws IOException {
        init();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new int[N+1][N+1];    // 1~N으로 번호가 주어지므로 크기 N+1로 초기화
        for (int i = 0; i <= N; i++) {   // 우선 모든 거리 무한대로 초기화
            for (int j = 0; j <= N; j++) {
                adj[i][j] = INFINITE;
            }
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {   // 비교가 된 물건들은 adj[무거운 물건][가벼운 물건]의 값 1로 변경
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());
            adj[heavy][light] = 1;
        }
    }

}
