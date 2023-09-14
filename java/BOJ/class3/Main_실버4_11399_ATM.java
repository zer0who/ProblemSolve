package BOJ.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_실버4_11399_ATM {

    private static int N;
    private static int[] timeForMoney;  // 각 번호 별 돈 뽑는데 걸리는 시간
    public static void main(String[] args) throws Exception {
        init();
        System.out.println(calcTime());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        timeForMoney = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            timeForMoney[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int calcTime() {
        int time = 0;
        Arrays.sort(timeForMoney);  // 오름차순 정렬
        int offset = 0;
        for (int i = 0; i < timeForMoney.length; i++) {
            time += timeForMoney[i] + offset;
            offset += timeForMoney[i];
        }

        return time;
    }

}
