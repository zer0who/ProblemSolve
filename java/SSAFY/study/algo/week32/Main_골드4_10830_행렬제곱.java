package SSAFY.study.algo.week32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_골드4_10830_행렬제곱 {

    static int N;
    static int B;
    static int[][] originMatrix;

    public static void main(String[] args) throws IOException {
        init();
    }

    static void init () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        originMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                originMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int[] pow(int[] matrix, int powerNumber) {

        return new int[2];
    }


}
