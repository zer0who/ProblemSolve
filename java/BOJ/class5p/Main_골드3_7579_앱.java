package BOJ.class5p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_골드3_7579_앱 {

    static int N, M;
    static int[] memories;
    static int[] costs;

    public static void main(String[] args) throws IOException {
        int totalCost = init();
        calcMin(totalCost);
    }

    static int init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memories = new int[N];
        costs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) memories[i] = Integer.parseInt(st.nextToken());
        int totalCost = 0;  // 배낭의 비용 한계치로 사용할 값
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            totalCost += costs[i];
        }

        return totalCost;
    }

    static void calcMin(int totalCost) {
        int answer = Integer.MAX_VALUE;
        int[][] dpArr = new int[N][totalCost+1];  // 이 배열의 각 값은 그 비용을 썼을 때 최대로 담을 수 있는 메모리, 열의 최대 값은 각 앱들 비용의 합
        int nowCost, nowMemory;
        boolean isFound = false;
        for (int j = 0; j < totalCost+1; j++) { // 나는 비용(열)을 기준으로 생각하는 게 편해서 바깥 반복문을 열로 지정함
            if (isFound) break;
            for (int i = 0; i < N; i++) {
                nowCost = costs[i];
                nowMemory = memories[i];
                if (i == 0) {   // 0번째 인덱스 앱에서는 i-1과 비교가 불가, 앱의 비용이 체크하려는 비용 이상일 때만 값 저장
                    if (nowCost <= j) dpArr[i][j] = nowMemory;
                } else {    // 이 부분은 냅색과 같음
                    if (nowCost <= j) dpArr[i][j] = Math.max(dpArr[i - 1][j - nowCost] + nowMemory, dpArr[i - 1][j]);
                    else dpArr[i][j] = dpArr[i - 1][j];
                }

                if (dpArr[i][j] >= M) { // 비용을 바깥 반복문으로 뒀으므로, M 이상을 충족하는 비용의 최소치를 찾은 경우이므로 더 이상의 반복이 필요 없음.
                    answer = j;
                    isFound = true;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

}
