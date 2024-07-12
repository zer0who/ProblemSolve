package BOJ.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드5_2294_동전2 {

    static int n, k;
    static int[] coins;

    public static void main(String[] args) throws IOException {
        init();
        calcCase();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());
        Arrays.sort(coins); // 동전을 가치의 오름차순으로 정렬
    }

    static void calcCase() {
        int maxValue = 100_000_000;
        int[] dpArr = new int[k+1];    // 크기가 k+1인 이유: 0 ~ k 까지 각 동전을 이용해서 값을 만들 수 있는 경우 중 최솟값을 저장해나가기 위함(knapsack)
        Arrays.fill(dpArr, maxValue);
        dpArr[0] = 0;
        int nowCoin;
        for (int i = 0; i < n; i++) { // 동전마다 최댓값 k까지 최소 개수로 만들 수 있는 경우를 계속 갱신
            nowCoin = coins[i];
            for (int j = nowCoin; j < k+1; j++) {

            }
        }
        if (dpArr[k] == maxValue) System.out.println(-1);
        else System.out.println(dpArr[k]);
    }

}
