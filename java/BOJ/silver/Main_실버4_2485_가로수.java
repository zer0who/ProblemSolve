package BOJ.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_실버4_2485_가로수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int before = Integer.parseInt(br.readLine());
        int nowGCD = 0;
        int now, diff;
        int[] diffs = new int[N-1]; // 입력받은 나무들 사이(i와 i+1)의 간격
        for (int i = 0; i < N-1; i++) {
            now = Integer.parseInt(br.readLine());
            diff = now - before;
            diffs[i] = diff;
            nowGCD = findGCD(nowGCD, diff);
            before = now;
        }

        int answer = 0;
        for (int i = 0; i < N-1;  i++) answer += ((diffs[i] / nowGCD) - 1);
        System.out.println(answer);
    }

    static int findGCD(int a, int b){   //최대 공약수 구하기 with 유클리드 호제법
        int r;
        while(b != 0){
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

}
