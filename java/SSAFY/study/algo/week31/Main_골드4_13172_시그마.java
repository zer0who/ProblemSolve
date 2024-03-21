package SSAFY.study.algo.week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_골드4_13172_시그마 {

    static final int MOD_NUM = 1_000_000_007;   // 문제에서 정의한 모듈로 스페이스
    static int M;
    static int[][] dices;

    public static void main(String[] args) throws IOException {
        init();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        dices = new int[M][2];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int Ni = Integer.parseInt(st.nextToken());
            int Si = Integer.parseInt(st.nextToken());
            dices[i] = new int[] {Ni, Si};
        }
    }

}
