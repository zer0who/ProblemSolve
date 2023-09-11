package BOJ.class2pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_실버2_1654_랜선자르기 {

    private static long answer;
    private static int N, K;
    private static long[] KLAN;

    public static void main(String[] args) throws Exception {
        init();
        bitSearch();
        System.out.println((int) answer);
    }

    private static void init() throws IOException {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        KLAN = new long[K];
        for (int i = 0; i < K; i++) {
            KLAN[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(KLAN);  // 이분 탐색을 해야하므로, 오름차순 정렬
    }

    private static void bitSearch() {
        long start = 1;
        long end = KLAN[K-1];   // 왜 long이냐? 정렬한 값의 맨끝값이 int의 마지막 값일 수 있으니까, mid의 연산에서 오버플로우가 발생할 수 있음. ^^ㅣ바
        long mid;
        answer = end;

        while (start <= end) {
            mid = (start + end) / 2;
            long tempQuotient = 0;   // 해당 길이로 자를 수 있는 랜선 개수
            for (int i = 0; i < K; i++) {
                tempQuotient += KLAN[i] / mid;
            }

            if (tempQuotient >= N) {    // N을 충족하면, 길이가 더 길어도 됨.
                start = mid + 1;    // 중간지점에서 +1한 만큼의 범위부터 잘라줌
                answer = mid; // 맨 처음 끝값을 +1 해줬기 때문에, 마지막에도 -1을 빼줌.
            } else {    // N을 충족하지 못하면, 길이가 더 짧아져야 함.
                end = mid - 1;  // mid 값도 포함이 안되니까, mid -1까지의 범위까지 잘라줌
            }
        }
    }

}
