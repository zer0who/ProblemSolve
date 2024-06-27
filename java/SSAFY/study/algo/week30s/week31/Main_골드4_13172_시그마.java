package SSAFY.study.algo.week30s.week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_골드4_13172_시그마 {

    static final int MOD_NUM = 1_000_000_007;   // 문제에서 정의한 모듈로 스페이스
    static int M;

    public static void main(String[] args) throws IOException {
        System.out.println(init());
    }

    static long init() throws IOException {
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // S1/N1 + S2/N2 + S3/N3 + ... 은 mod X 스페이스에서
        // S1N1^(X-2) + S2N2^(X-2) + S3N3^(X-2) + ... % MOD_NUM와 같아짐(mod 스페이스 적용, 페르마의 소정리 적용)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int g = gcd(Math.max(N, S), Math.min(N, S));    // 최대공약수를 찾아 N, S를 기약분수 형태로 변형
            N /= g;
            S /= g;
            answer += S * f(N,MOD_NUM-2) % MOD_NUM; // S * N^(X-2) mod X
            answer %= MOD_NUM;
        }

        return answer;
    }

    static int gcd(int a, int b) {  // N과 S의 최대공약수를 찾아내주는 함수
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }

    static long f(long b, long n) { // 분할정복을 이용한 거듭제곱
        if(n == 1) return b;

        long p = f(b,n/2);
        long ret = p * p % MOD_NUM;
        if(n%2 == 1) {
            ret = ret * b % MOD_NUM;
        }

        return ret;
    }

}
