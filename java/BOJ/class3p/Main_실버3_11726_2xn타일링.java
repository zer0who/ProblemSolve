package BOJ.class3p;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_실버3_11726_2xn타일링 {

    public static void main(String[] args) throws Exception {
        int[] wayTiling = new int[1001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        wayTiling[1] = 1;
        wayTiling[2] = 2;

        for (int i = 3; i <= N; i++) {
            wayTiling[i] = (wayTiling[i-1] + wayTiling[i-2]) % 10007;
        }
        System.out.println(wayTiling[N]);
    }

}
