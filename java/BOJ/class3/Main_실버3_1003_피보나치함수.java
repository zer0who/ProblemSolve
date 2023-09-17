package BOJ.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_실버3_1003_피보나치함수 {

    private static int[] callZero;  // 0을 호출하는 횟수
    private static int[] callOne;   // 1을 호출하는 횟수

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) { // N이 0또는 1이면 점화식으로 일반화 불가
                sb.append(1 + " " + 0 + "\n");
                continue;
            } else if (N == 1) {
                sb.append(0 + " " + 1 + "\n");
                continue;
            }
            callZero = new int[N + 1];
            callOne = new int[N + 1];
            callZero[0] = 1;    // N이 0, 1일 때 초기화
            callZero[1] = 0;
            callOne [0] = 0;
            callOne[1] = 1;
            for (int i = 2; i < N+1; i++) {
                callZero[i] = callZero[i-2] + callZero[i-1];
                callOne[i] = callOne[i-2] + callOne[i-1];
            }
            sb.append(callZero[N] + " " + callOne[N]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
