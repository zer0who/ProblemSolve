package BOJ.class4p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_실버1_9465_스티커 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];
            StringTokenizer st;
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] score = new int[2][n];
            score[0][0] = stickers[0][0];
            score[1][0] = stickers[1][0];
            if (n != 1) {
                score[0][1] = score[1][0] + stickers[0][1];
                score[1][1] = score[0][0] + stickers[1][1];

                for (int i = 2; i < n; i++) {
                    score[0][i] = Math.max(score[1][i - 1], score[1][i - 2]) + stickers[0][i];
                    score[1][i] = Math.max(score[0][i - 1], score[0][i - 2]) + stickers[1][i];
                }
                System.out.println(Math.max(score[0][n - 1], score[1][n - 1]));
            } else System.out.println(Math.max(score[0][0], score[1][0]));
        }
    }

}
