package BOJ.to_tamjeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2786_상근이의레스토랑 {

    static int N;
    static long[][] foods;
    static long[] minDiff;
    static long[] totalSumForSecondFood;
    static int[] minFirstOrder; // i번째 음식 이후의 음식 중 가장 낮은 첫 주문 값 저장

    public static void main(String[] args) throws IOException {
        init();
        doOrder();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        foods = new long[N+1][2];
        StringTokenizer st;
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            foods[i][0] = Long.parseLong(st.nextToken());
            foods[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(foods, new Comparator<long[]>() {   // 두 번째 주문 가격 기준 정렬
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int) o1[1] - (int) o2[1];
            }
        });

        minDiff = new long[N+1];
        minDiff[0] = 1_000_000_001;
        totalSumForSecondFood = new long[N+1];
        minFirstOrder = new int[N+1];
        minFirstOrder[N] = (int) foods[N][0];
        for (int i = 1; i < N+1; i++) { // N이 50만이기 때문에 O(N)만에 누적 합, i까지의 음식들을 제외한 것 중 최소의 a가격, a와 b의 차이 중 최솟값을 저장해줘야 함
            minFirstOrder[N-i] = Math.min(minFirstOrder[N-i+1], (int) foods[N-i][0]);
            minDiff[i] = Math.min(minDiff[i-1], foods[i][0] - foods[i][1]);
            totalSumForSecondFood[i] = totalSumForSecondFood[i-1] + foods[i][1];
        }
    }

    static void doOrder() {    // quantity: 주문할 음식의 양
        StringBuilder sb = new StringBuilder();
        sb.append(minFirstOrder[1]).append("\n");

        // 최솟값이 될 수 있는 경우 => 1. b 기준 n-1개 선택 후 선택 안한 음식 중 a값이 가장 싼 것 선택 / 2. b 기준 n개 선택 후 그 중 a와 b의 가격 차이가 최소인 것의 가격을 더하기
        // 위의 두 경우 중 최솟값이 정답임
        for (int n = 2; n <= N; n++) sb.append(Math.min(totalSumForSecondFood[n] + minDiff[n], totalSumForSecondFood[n-1] + minFirstOrder[n])).append("\n");

        System.out.println(sb);
    }

}
