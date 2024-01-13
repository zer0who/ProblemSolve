package SSAFY.study.algo.week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_골드5_22251_빌런호석 {

    static int[][] diff =   // 각 수 별로 숫자를 바꿀 때 반전시키는 횟수
            new int[][] {{0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
                    {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
                    {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
                    {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
                    {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
                    {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
                    {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
                    {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
                    {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
                    {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}};

    static int N, K, P, X; // N: 가능한 층 범위, K: 세그먼트 자리 수, P: 반전 가능 개수, X: 지금 층

    public static void main(String[] args) throws IOException {
        init();
        calcCase();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
    }

    static void calcCase() {

    }

}
