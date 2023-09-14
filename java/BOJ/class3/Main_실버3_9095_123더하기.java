package BOJ.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_실버3_9095_123더하기 {

    private static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            sb.append(calcCase(n));
        }
        System.out.println(sb);
    }

    private static int calcCase(int n) {
        int rt = 0;

        return rt;
    }
}
