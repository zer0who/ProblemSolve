package SSAFY.study.algo.week60s.week64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_25565_딸기와토마토 {

    static int K;
    static int[][] seeds;

    public static void main(String[] args) throws IOException {
        init();

    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        seeds = new int[N][M];

    }

    static void findAxis() {

    }

}
