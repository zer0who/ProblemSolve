package BOJ.to_tamjeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2786_상근이의레스토랑 {

    static int N;
    static long[][] foods;

    public static void main(String[] args) throws IOException {
        init();
        doOrder();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        foods = new long[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            foods[i][0] = Long.parseLong(st.nextToken());
            foods[i][1] = Long.parseLong(st.nextToken());
        }
    }

    static void doOrder() {    // quantity: 주문할 음식의 양
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= N; i++) {

        }
        System.out.println(sb);

    }

}
