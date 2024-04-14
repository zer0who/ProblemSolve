package BOJ.class4p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_골드4_2448_별찍기11 {

    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][(2*N)-1];
        printStar(0, N-1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (2*N) - 1; j++) {
                if (arr[i][j] == '*') sb.append(arr[i][j]);
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void printStar(int r, int c, int n) {
        if (n == 3) {
            arr[r][c] = '*';

            arr[r+1][c-1] = '*';
            arr[r+1][c+1] = '*';

            arr[r+2][c-2] = '*';
            arr[r+2][c-1] = '*';
            arr[r+2][c] = '*';
            arr[r+2][c+1] = '*';
            arr[r+2][c+2] = '*';
            return;
        }

        int size = n / 2;
        printStar(r, c, size);
        printStar(r+size, c-size, size);    // 왼쪽 아래
        printStar(r+size, c+size, size);    // 오른쪽 아래
    }

}
