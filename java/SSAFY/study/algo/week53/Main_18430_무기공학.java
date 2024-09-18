package SSAFY.study.algo.week53;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18430_무기공학 {

    static int[][] dirRow = new int[][] {{0, 1}, {0, 1}, {-1, 0}, {-1, 0}};    // 부메랑 네 방향, 1. ㄱ 왼쪽으로 뒤집은 거, 2. ㄱ, 3. ㄴ 오른쪽으로 뒤집은 거, 4. ㄴ
    static int[][] dirCol = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    static int N, M;
    static int[][] wood;
    static int maxStrength;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 0, 0, new boolean[N][M]);
        System.out.println(maxStrength);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        wood = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                wood[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxStrength = 0;
    }

    static void dfs(int row, int col, int strength, boolean[][] isUsed) {
        if (row == N-1 && col == M-1) { // 기저, 모든 칸을 다 체크해봤을 경우
            maxStrength = Math.max(0, maxStrength);
            return;
        }

        int nextCenterRow = (col+1 == M)? row+1:row;
        int nextCenterCol = (col+1 == M)? 0:col+1;
        if (isUsed[row][col]) dfs(nextCenterRow, nextCenterCol, strength, isUsed);   // 이미 부메랑을 만드는 데 쓴 칸이라면 다음 칸 탐색으로

        int sideRow1, sideCol1, sideRow2, sideCol2, nextStrength;
        for (int d = 0; d < 4; d++) {   // 부메랑을 만들 수 있는 네 방향에 대해서
            sideRow1 = row + dirRow[d][0];
            sideCol1 = col + dirCol[d][0];
            sideRow2 = row + dirRow[d][1];
            sideCol2 = col + dirCol[d][1];
            if (isOuted(sideRow1, sideCol1) || isOuted(sideRow2, sideCol2) || isUsed[sideRow1][sideCol1] || isUsed[sideRow2][sideCol2]) continue;   // 이 칸에서는 부메랑 만들기 불가
            nextStrength = wood[row][col] * 2 + wood[sideRow1][sideCol1] + wood[sideRow2][sideCol2];
            isUsed[row][col] = true;
            isUsed[sideRow1][sideCol1] = true;
            isUsed[sideRow2][sideCol2] = true;
            dfs(nextCenterRow, nextCenterCol, strength+nextStrength, isUsed);
            isUsed[row][col] = false;
            isUsed[sideRow1][sideCol1] = false;
            isUsed[sideRow2][sideCol2] = false;
        }
    }

    static boolean isOuted(int row, int col) {
        if ((0 <= row && row < N) && (0 <= col && col < M)) return false;
        return true;
    }

}
