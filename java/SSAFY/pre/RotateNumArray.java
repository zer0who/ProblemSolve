package SSAFY.pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RotateNumArray {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] numArr = makeNumArr(br, N);
            int[][] numArr90 = rotate90(numArr, N);
            int[][] numArr180 = rotate90(numArr90, N);
            int[][] numArr270 = rotate90(numArr180, N);

            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(numArr90[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(numArr180[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(numArr270[i][j]);
                }
                System.out.println("");
            }
        }
    }

    private static int[][] makeNumArr(BufferedReader br, int N) throws IOException {
        int[][] numArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return numArr;
    }

    private static int[][] rotate90(int[][] numArr, int N) {
        int[][] rotated = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[i][j] = numArr[N-1-j][i];
            }
        }

        return rotated;
    }

}
