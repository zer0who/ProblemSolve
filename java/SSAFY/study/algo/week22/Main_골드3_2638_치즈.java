package SSAFY.study.algo.week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_골드3_2638_치즈 {

    static int N, M;
    static int[][] cheese;
    static int melted;  // 녹은 개수 카운트, 0개가 되면 다 녹은 것
    static int hour;    // 걸린 시간 카운트

    public static void main(String[] args) throws IOException {
        init();
        while (melted > 0) {
            cheeseMelt();
        }
        System.out.println(hour);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];
        melted = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int info = Integer.parseInt(st.nextToken());
                if (info == 1) melted += 1;
                cheese[i][j] = info;
            }
        }
        hour = 0;
    }
    
    static void cheeseMelt() {

    }

}
