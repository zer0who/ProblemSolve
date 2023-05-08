package BOJ.divisor_multiple_prime_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Colonnade {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] colonnades = new int[N];
        for (int i=0; i<N; i++) {   // 최대, 최소 차이 구하고 최소가 최대의 약수이면 그대로, 아니면 둘의 최대공약수로
            st = new StringTokenizer(bf.readLine());
            colonnades[i] = Integer.parseInt(st.nextToken());
        }

    }
}