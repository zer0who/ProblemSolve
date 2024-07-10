package SSAFY.study.algo.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_골드2_27450_플래그대사그만좀말해요 {

    static int N, K;
    static int[] initStrength;  // 처음 주어지는 강함 수치
    static int[] goalStrength;  // 목표 강함 수치

    public static void main(String[] args) throws IOException {
        init();
        calcShout();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        initStrength = new int[N];
        goalStrength = new int[N];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            initStrength[i] = Integer.parseInt(st.nextToken());
            goalStrength[i] = Integer.parseInt(st2.nextToken());
        }
    }

    static void calcShout() {
        long answer = 0;

        long[] shout = new long[N]; // 인덱스 별 부하들을 강화시키기 위해 필요한 외침의 횟수 저장
        long diff, neededCount, inc, cnt = 0, inh = 0;   // 현재 위치의 부하를 강화시키기 위해 필요한 숫자, 그 숫자만큼 강화하기 위한 외침의 횟수
        for (int i = 0; i < N; i++) {
            if (i > 0) inh -= cnt;  // 두 번째 부하부터는 한 칸 움직일 때마다 이전의 외침 횟수는 강화에 영향을 주지 않음
            if (i >= K) {
                cnt -= shout[i-K];  // K칸 이전의 외침은 현재 부하에게 영향을 끼치지 않음
                inh += K * shout[i-K];
            }

            inc = cnt * K + inh;    // 이전까지 외침으로 인해 증가된 강함
            diff = (goalStrength[i] - initStrength[i]) - inc;
            if (diff > 0) { // 강화시키기 위해 외침이 필요한 경우
                neededCount = (diff % K == 0) ? diff/K : diff/K + 1;

                answer += neededCount;
                shout[i] += neededCount;   // 외침 필요한 개수만큼 더해 줌
                cnt += neededCount;
            }
        }

        System.out.println(answer);
    }

}
