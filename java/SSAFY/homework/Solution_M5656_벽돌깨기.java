package SSAFY.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_M5656_벽돌깨기 {

    static int[] dirRow = new int[] {-1, 1, 0, 0};
    static int[] dirCol = new int[] {0, 0, -1, 1};

    static class Brick {
        int row;
        int col;
        int range;    // 터지는 범위

        public Brick(int row, int col, int range) {
            this.row = row;
            this.col = col;
            this.range = range;
        }
    }

    static int min_remain;    // 마지막에 남은 구슬 수, 작을 수록 정답
    static int N, H, W;    // 	N: 구슬 쏘는 횟수, H: 행, W: 열
    static int[][] ogBricks;    // 원래 벽돌들(한 게임 끝날 때마다 상태 되돌리기 위함)
    static int[][] bricks;    // 벽돌들
    static int[] drops;    // 벽돌 떨어뜨릴 위치

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            init(br);
            permutation(0);
            sb.append(min_remain).append("\n");
        }
        System.out.println(sb);
    }

    static void init(BufferedReader br) throws IOException {
        min_remain = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ogBricks = new int[H][W];
        bricks = new int[H][W];
        drops = new int[N];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                int range = Integer.parseInt(st.nextToken());
                ogBricks[i][j] = range;
                bricks[i][j] = range;
            }
        }
    }

    static Brick findTopBrick(int drop) {
        int row = 0;

        Brick topBrick = null;
        while (row < H) {    // 떨어뜨릴 열에 있는 벽돌 중 가장 위 벽돌 찾을 때까지
            if (bricks[row][drop] != 0) {    // 벽돌 찾음
                topBrick = new Brick(row, drop, bricks[row][drop]);
                break;
            }

            row += 1;
        }

        return topBrick;
    }

    static boolean isOuted(int row, int col) {
        if ((0 <= row && row < H) && (0 <= col && col < W)) return false;

        return true;
    }

    static void downBricks() {    // 폭탄 터진 후 벽돌들 내려주기
        for (int i = 0; i < W; i++) {    // 모든 열들에 대해
            for (int j = H-1; j >= 0; j--) {
                if (bricks[j][i] == 0) {    // 빈 칸이면
                    int h = j;
                    while (h >= 0) {  // 벽돌 찾을 때까지
                        if (bricks[h][i] != 0) {
                            bricks[j][i] = bricks[h][i];
                            bricks[h][i] = 0;
                            break;
                        }
                        h -= 1;
                    }
                }
            }
        }
    }

    static void doGame(int drop) {    // drop: 떨어뜨릴 위치(열)
        Brick topBrick = findTopBrick(drop);
        if (topBrick == null) return;    // 구슬 떨어뜨린 열에 벽돌이 없으면 해당 위치는 함수 종료

        Queue<Brick> queue = new ArrayDeque<>();
        queue.offer(topBrick);

        while(!queue.isEmpty()) {    // 폭탄 다 터트림
            Brick nowBrick = queue.poll();
            int row = nowBrick.row;
            int col = nowBrick.col;
            int range = nowBrick.range;    // 폭발 범위
            bricks[row][col] = 0;    // 벽돌 제거 처리
            for (int i = 0; i < 4; i++) {
                int rowOffset = dirRow[i];
                int colOffset = dirCol[i];
                for (int j = 0; j < range-1; j++) {    // 폭발 범위동안 퍼짐
                    int nextRow = row + rowOffset;
                    int nextCol = col + colOffset;
                    if (!isOuted(nextRow, nextCol) && bricks[nextRow][nextCol] != 0) {
                        queue.offer(new Brick(nextRow, nextCol, bricks[nextRow][nextCol]));
                    }
                    rowOffset += dirRow[i];    // 다음 범위로
                    colOffset += dirCol[i];
                }
            }
        }

        downBricks();
    }

    static int resetBricks() {    // 한 게임 끝나면 원래 상태로 되돌리면서 남은 벽돌 개수 세기
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (bricks[i][j] != 0) cnt += 1;
                bricks[i][j] = ogBricks[i][j];
            }
        }

        return cnt;
    }

    static void permutation(int cnt) {    // 떨어뜨릴 위치 정하기
        if (min_remain == 0) return;    // 모든 폭탄 제거되면 그냥 return
        if (cnt == N) {    // 떨어뜨릴 위치 다 정했으면 벽돌 떨어뜨려보기
            for (int i = 0; i < drops.length; i++) {
                doGame(drops[i]);
            }
            int remain = resetBricks();
            if (remain < min_remain) min_remain = remain;

            return;
        }

        for (int i = 0; i < W; i++) {
            drops[cnt] = i;
            permutation(cnt+1);
        }
    }

}
