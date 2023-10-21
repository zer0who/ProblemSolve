package SSAFY.study.algo.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_실버1_6064_카잉달력 {

    static int M, N, x, y;  // M: x의 최댓값, N: y의 최댓값

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            init(br);
            long answer = kaing();
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
    }

    static int calcGCD(int n1, int n2) {    // 유클리드 호제법을 이용한 최대 공약수 구하기
        int r = 0;
        while (n2 > 0) {
            r = n1 % n2;
            n1 = n2;
            n2 = r;
        }

        return n1;
    }

    static long calcLSM() {  // 최소 공배수 = 두 수의 곱 / 두 수의 최대 공약수
        int n1 = M;
        int n2 = N;
        int gcd = calcGCD(n1, n2);

        return M * N / gcd;
    }

    static long kaing() {
        long endYear = calcLSM();    // 카잉 달력의 마지막 해 -> M, N의 최소 공배수(처음으로 x, y가 M, N으로 맞춰지는 순간이니까)
        long cnt = 1;   // 1년부터 시작
        while (true) {  // -> while문으로 돌면 반례 보니까 16억 번도 돔. 시간초과 나는 게 당연
            if (cnt > endYear) return -1;
            if ((cnt % M) == x % M && (cnt % N) == y % N) break;
            cnt += 1;
        }

        return cnt;
    }


}
