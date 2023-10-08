package BOJ.class3p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_실버1_1074_Z {

    static int answer, N, r, c, size;

    public static void main(String[] args) throws IOException {
        init();
        count(r, c, size);
        System.out.println(answer);
    }

    static void init() throws IOException {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, N);
    }

    static void count(int row, int col, int size) {
        if (size == 1) return;  // 사이즈가 1이면 종료

        int half = size / 2;
        if (row < half && col < half) {
            count(row, col, half);
        } else if (row < half && half <= col) {
            answer += size * size / 4;
            count(row, col-half, half);
        } else if (half <= row && col < half) {
            answer += size * size / 4 * 2;
            count(row-half, col, half);
        } else if (half <= row && half <= col) {
            answer += size * size / 4 * 3;
            count(row-half, col-half, half);
        }
    }

}
