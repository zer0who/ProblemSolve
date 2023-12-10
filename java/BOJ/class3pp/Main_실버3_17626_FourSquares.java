package BOJ.class3pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_실버3_17626_FourSquares {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1];
            for (int j = 1; j*j < i+1; j++) {
                dp[i] = Math.min(dp[i], dp[i-(j*j)]);
            }
            dp[i] += 1;
        }
        System.out.println(dp[n]);
    }

}
