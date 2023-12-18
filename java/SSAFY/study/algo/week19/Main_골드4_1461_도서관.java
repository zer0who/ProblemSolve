package SSAFY.study.algo.week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_골드4_1461_도서관 {

    static int N, M;
    static int[] bookAxis;

    public static void main(String[] args) {

    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bookAxis = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) bookAxis[i] = Integer.parseInt(st.nextToken());
    }

}
