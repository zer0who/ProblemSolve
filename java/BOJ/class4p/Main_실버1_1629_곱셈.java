package BOJ.class4p;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_실버1_1629_곱셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        if (A == 1) System.out.println(A % C);
        else System.out.println(doPow(A, B, C));
    }

    static long doPow(long a, long b, long c) {
        if (b == 1) return a%c; // 기저

        long temp = doPow(a, b/2, c);
        if (b % 2 == 0) return (temp * temp) % c;
        else return ( ( (temp * temp) % c ) * a ) % c;
    }

}
