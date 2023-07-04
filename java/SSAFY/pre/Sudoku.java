package SSAFY.pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sudoku {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc ++) {
            int answer = 0;
            int[][] sudoku_board = sudokuMap(br);
            if (checkCross(sudoku_board) && checkSquare(sudoku_board)) answer = 1;

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static int[][] sudokuMap(BufferedReader br) throws IOException {
        int[][] sudoku_board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku_board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return sudoku_board;
    }

    public static boolean checkCross(int[][] sudoku_board) {
        for (int i = 0; i < 9; i++) {   // 행의 경우 [i][j], 열의 경우 [k][i]
            boolean[] row_check = new boolean[9];   // 행 체크용
            boolean[] col_check = new boolean[9];   // 열 체크용
            for (int j = 0; j < 9; j++){    // 행 체크
                if (row_check[sudoku_board[i][j]-1]) return false;  // 이미 나왔던 수면 틀린 스도쿠
                else row_check[sudoku_board[i][j]-1] = true;  // 나온 수는 체크
            }

            for (int k = 0; k < 9; k++) {   // 열 체크
                if (col_check[sudoku_board[k][i]-1]) return false;
                else col_check[sudoku_board[k][i]-1] = true;
            }
        }

        return true;
    }

    public static boolean checkSquare(int[][] sudoku_board) {
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j < 6; j += 3) {
                boolean[] squareCheck = new boolean[9];
                for (int k = i; k < i+3; k++) { // 3x3에 대한 검증 시작
                    for (int l = j; l < j+3; l++) {
                        if (squareCheck[sudoku_board[k][l]-1]) return false;
                        else squareCheck[sudoku_board[k][l]-1] = true;
                    }
                }
            }
        }

        return true;
    }

}
