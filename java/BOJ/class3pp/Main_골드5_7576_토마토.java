package BOJ.class3pp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_골드5_7576_토마토 {

    private static int[] dirRow = {-1, 0, 1, 0};
    private static int[] dirCol = {0, 1, 0, -1};

    private static int col, row;
    private static int[][] tomatoes;
    private static int answer;
    private static boolean noRottenFlag;

    private static class Tomato {
        int row;
        int col;

        public Tomato(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String toString() {
            return this.row + " " + this.col;
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        if (noRottenFlag) {	// 전부 다 익은 토마토면 0출력하고 끝
            System.out.println(0);
            return;
        }
        bfs();
        System.out.println(answer);

    }

    private static void init() throws Exception {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        noRottenFlag = true;
        tomatoes = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 0) noRottenFlag = false;
                tomatoes[i][j] = input;
            }
        }
    }

    private static boolean isOutedOrBlocked(int r, int c) {
        if ((0 <= r && r < row) && (0 <= c && c < col) && (tomatoes[r][c] != -1)) {
            return false;
        }
        return true;
    }

    private static boolean alreadyTomato(int r, int c) {
        if (tomatoes[r][c] == 1) {
            return true;
        }
        return false;
    }

    private static void bfs() {
        Queue<Tomato> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {	// 큐 초기화
            for (int j = 0; j < col; j++) {
                if (tomatoes[i][j] == 1) {
                    queue.offer(new Tomato(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int qS = 0; qS < queueSize; qS++) {	// 처음 큐 사이즈만큼 돌고 날짜 +1
                Tomato polledTomato = queue.poll();
                for (int i = 0; i < dirRow.length; i++) {	// 토마토의 사방에 대해서
                    for (int j = 0; j < dirCol.length; j++) {
                        int nextRow = polledTomato.row + dirRow[i];
                        int nextCol = polledTomato.col + dirCol[i];
                        if (!isOutedOrBlocked(nextRow, nextCol) && !alreadyTomato(nextRow, nextCol)) {
                            tomatoes[nextRow][nextCol] = 1;
                            queue.offer(new Tomato(nextRow, nextCol));
                        }
                    }
                }
            }
            answer += 1;
        }
        answer -= 1;

        for (int i = 0; i < row; i++) {	// 안익은 토마토 아직 있으면
            for (int j = 0; j < col; j++) {
                if (tomatoes[i][j] == 0) {
                    answer = -1;	// 정답 -1로
                }
            }
        }
    }

}
