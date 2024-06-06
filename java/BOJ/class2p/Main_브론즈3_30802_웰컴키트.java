package BOJ.class2p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_브론즈3_30802_웰컴키트 {

    static int N;
    static int T, P;
    static int[] requestedTees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        requestedTees = new int[6];
        for (int i = 0; i < 6; i++) requestedTees[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        int teeCount = 0;
        for (int i = 0; i < 6; i++) {
            teeCount += (requestedTees[i] / T);
            if (requestedTees[i] % T != 0) teeCount += 1;
        }
        System.out.println(teeCount);
        System.out.println(N / P + " " + N % P);
    }

}
