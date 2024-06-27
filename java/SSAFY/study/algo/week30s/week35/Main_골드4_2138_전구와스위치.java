package SSAFY.study.algo.week30s.week35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_골드4_2138_전구와스위치 {

    static int N;
    static int[] initBulb;
    static int[] targetBulb;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(doSwitch());
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        initBulb = new int[N];
        targetBulb = new int[N];
        String input = br.readLine();
        for (int i = 0; i < N; i++) initBulb[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        input = br.readLine();
        for (int i = 0; i < N; i++) targetBulb[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
    }

    static int doSwitch() {
        int count;
        int temp1 = 0;  // 1번 스위치를 누르지 않은 채로 진행했을 때의 값
        int temp2 = 1;  // 1번(index 0) 스위치를 누른 채로 진행했을 때의 값
        int[] firstBulbChanged = Arrays.copyOf(initBulb, N);
        firstBulbChanged[0] = Math.abs(firstBulbChanged[0]-1);
        firstBulbChanged[1] = Math.abs(firstBulbChanged[1]-1);
        for (int i = 0; i < N-1; i++) {
            // 보통 전구에 대해
            if (doSwitch(initBulb, i)) temp1++;
            // 1번 전구를 켠 전구에 대해
            if (doSwitch(firstBulbChanged, i)) temp2++;
        }
        if (initBulb[N-1] != targetBulb[N-1]) temp1 = -1;
        if (firstBulbChanged[N-1] != targetBulb[N-1]) temp2 = -1;

        if (temp1 == -1) count = temp2;
        else if (temp2 == -1) count = temp1;
        else count = Math.min(temp1, temp2);    // 둘 다 가능한 경우(temp1 != -1, temp2 != -1)였을 때

        return count;
    }

    static boolean doSwitch(int[] bulbs, int index) {
        if (bulbs[index] != targetBulb[index]) {
            bulbs[index] = Math.abs(bulbs[index] - 1);
            bulbs[index+1] = Math.abs(bulbs[index+1] - 1);
            if (index != N-2) bulbs[index+2] = Math.abs(bulbs[index+2] - 1);
            return true;
        } else return false;
    }

}
