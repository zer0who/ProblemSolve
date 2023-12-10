package BOJ.class3pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_실버2_21736_헌친필 {

    static int[] dirRow = new int[] {-1, 1, 0, 0};  // 상 하 좌 우
    static int[] dirCol = new int[] {0, 0, -1, 1};

    static int N, M;
    static String[][] campus;
    static int metPeople;

    static class Doyeon {
        int row;
        int col;

        public Doyeon(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        Doyeon initDoyeon = init();
        bfs(initDoyeon);
        if (metPeople == 0) System.out.println("TT");
        else System.out.println(metPeople);
    }

    static Doyeon init() throws IOException {
        Doyeon initDoyeon = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new String[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < row.length(); j++) {
                String campusInfo = String.valueOf(row.charAt(j));
                if (campusInfo.equals("I")) initDoyeon = new Doyeon(i, j);
                campus[i][j] = campusInfo;
            }
        }
        metPeople = 0;

        return initDoyeon;
    }

    static boolean isOuted(int row, int col) {
        if ((0 <= row && row < N) && (0 <= col && col < M)) return false;
        return true;
    }

    static void bfs(Doyeon initDoyeon) {
        boolean[][] isVisited = new boolean[N][M];
        Queue<Doyeon> queue = new ArrayDeque<>();
        queue.offer(initDoyeon);
        isVisited[initDoyeon.row][initDoyeon.col] = true;

        while (!queue.isEmpty()) {
            Doyeon nowDoyeon = queue.poll();
            int row = nowDoyeon.row;
            int col = nowDoyeon.col;
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dirRow[i];
                int nextCol = col + dirCol[i];
                if (!isOuted(nextRow, nextCol) && !campus[nextRow][nextCol].equals("X") && !isVisited[nextRow][nextCol]) {
                    if (campus[nextRow][nextCol].equals("P")) metPeople += 1;
                    queue.offer(new Doyeon(nextRow, nextCol));
                    isVisited[nextRow][nextCol] = true;
                }
            }
        }
    }

}
