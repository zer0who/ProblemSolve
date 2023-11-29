package BOJ.class3pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_실버1_1389_케빈베이컨의6단계법칙 {

    static int N, M;
    static int[][] adj; // 인접 행렬

    public static void main(String[] args) throws IOException {
        init();
        int answer = Integer.MAX_VALUE;
        int answer_user = 0;
        for (int i = 1; i < N+1; i++) {
            int temp = 0;   // i번 유저의 케빈 베이컨 수 합
            for (int j = 1; j < N+1; j++) {
                if (i != j) {
                    int cnt = bfs(i, j);
                    temp += cnt;
                }
            }
            System.out.println(temp);
            System.out.println("=====" + i + "번 유저 종료=====");

            if (answer > temp) {
                answer = temp;
                answer_user = i;
            }
        }
        System.out.println(answer_user);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new int[N+1][N+1];    // 1번부터 세니까 N+1크기만큼의 배열 생성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from][to] = 1;
            adj[to][from] = 1;
        }
    }

    static int bfs(int start, int end) {   // start번에서 end번으로 가는 케빈 베이컨 수 카운트
        System.out.println(start+ "번의 " + end + "로 카운팅 시작");
        int result = 0;
        boolean[] isVisited = new boolean[N+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            result += 1;
            for (int q = 0; q < queueSize; q ++) {
                int nowUser = queue.poll();
                for (int i = 1; i < N+1; i++) {
                    int linked = adj[nowUser][i];
                    if (linked == 0) continue;
                    else if (isVisited[linked]) continue;
                    if (i == end) return result;
                    queue.offer(linked);
                    isVisited[linked] = true;
                }
            }
        }
        System.out.println("결과: " + result);

        return result;
    }

}
