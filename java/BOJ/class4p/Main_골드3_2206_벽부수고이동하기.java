package BOJ.class4p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_골드3_2206_벽부수고이동하기 {

    static class Hoo {  // 맵을 움직이는 김영후
        int row;
        int col;
        int count;
        boolean crashed;    // 벽을 부쉈는지 여부

        public Hoo(int row, int col, int count, boolean crashed) {
            this.row = row;
            this.col = col;
            this.count = count;
            this.crashed = crashed;
        }
    }

    static int[] dirRow = new int[] {-1, 1, 0, 0};
    static int[] dirCol = new int[] {0, 0, -1, 1};

    static int N, M;
    static int[][] map;
    static int minCount;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        if (minCount == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minCount);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }
        minCount = Integer.MAX_VALUE;
    }

    static boolean isOuted(int row, int col) {
        if ((0 <= row && row < N) && (0 <= col && col < M)) return false;

        return true;
    }

    static void bfs() {
        Hoo initHoo = new Hoo(0, 0, 1, false);
        boolean[][][] isVisited = new boolean[2][N][M]; // 0: 벽 안부쉈을 때, 1: 벽 부쉈을 때
        Queue<Hoo> queue = new ArrayDeque<>();
        queue.offer(initHoo);
        isVisited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Hoo now = queue.poll();
            if (now.row == N-1 && now.col == M-1) { // 도착지 도착하면 끝
                minCount = now.count;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nextRow = now.row + dirRow[d];
                int nextCol = now.col + dirCol[d];

                if (isOuted(nextRow, nextCol)) continue;    // 범위 밖이면 패스
                if ((!now.crashed && isVisited[0][nextRow][nextCol]) || (now.crashed && isVisited[1][nextRow][nextCol])) continue; // 아무 경우나 방문했던 적이 있으면 패스
                if (now.crashed && map[nextRow][nextCol] == 1) continue;    // 이미 부쉈고 벽을 만난 경우면 패스
                if (!now.crashed && map[nextRow][nextCol] == 1) {   // 벽을 한 번이라도 부쉈다면, 벽 아닌 곳만 이동 가능
                    queue.offer(new Hoo(nextRow, nextCol, now.count+1, true));
                } else {    // 벽 부순 적 없으면 벽 한 번 부수기 가능
                    queue.offer(new Hoo(nextRow, nextCol, now.count+1, now.crashed));
                    if (!now.crashed) isVisited[0][nextRow][nextCol] = true;
                    else isVisited[1][nextRow][nextCol] = true;
                }
            }
        }
    }

}
