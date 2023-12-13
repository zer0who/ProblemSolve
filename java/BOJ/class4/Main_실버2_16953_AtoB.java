package BOJ.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_실버2_16953_AtoB {

    static int minCount;
    static boolean minChanged;  // 계산이 가능해 최솟값이 갱신됐는지 여부

    public static void main(String[] args) throws IOException {
        minCount = Integer.MAX_VALUE;
        minChanged = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        dfs(A, B, 0);

        if (!minChanged) System.out.println(-1);
        else System.out.println(minCount+1);
    }

    static void dfs(long A, long B, int cnt) {
        if (A == B) {
            minCount = Math.min(minCount, cnt);
            minChanged = true;
            return;
        } else if (A > B) return;

        long originalA = A;
        A = A*2;
        dfs(A, B, cnt+1);
        A = originalA;
        A = Long.parseLong(String.valueOf(A) + "1");
        dfs(A, B, cnt+1);
    }

}
