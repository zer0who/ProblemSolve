package SSAFY.study.algo.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_골드5_1107_리모컨 {

    static final int START_CHANNEL = 100;   // 첫 채널
    static int N, M;    // N: 목적지
    static int N_LENGTH;    // 목적지 채널의 숫자 개수
    static Map<Integer, Boolean> broken;
    static int minDiff; // N과의 차이가 가장 적은 채널과의 차이

    public static void main(String[] args) throws IOException {
        init();
        if (N == START_CHANNEL) System.out.println(0);  // 목적 채널이 시작 채널이면 0 출력
        else if (M == 0) System.out.println(N_LENGTH);  // 고장난 버튼이 0개이면 중복조합 없이 목적지 채널 숫자 수 출력
        else {  // 중복조합으로 가장 가까운 채널 구해서, 그 채널과 목적지 채널의 차이를 더해준 것 출력
            permutation(0, new int[N_LENGTH]);
            System.out.println(minDiff + N_LENGTH);
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        N_LENGTH = String.valueOf(N).length();
        broken = new HashMap<>();
        minDiff = Math.abs(START_CHANNEL-N);
        for (int i = 0; i < 10; i++) broken.put(i, false);

        if (M == 0) return; // M이 0이면 고장난 버튼 없음
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            broken.replace(number, true);   // 고장난 버튼 처리
        }
    }

    static String makeChannel(int[] selected) {
        String madeChannel = "";
        for (int i = 0; i < selected.length; i++) madeChannel += String.valueOf(selected[i]);

        return madeChannel;
    }

    static void permutation(int cnt, int[] selected) {  // 중복순열
        if (cnt == N_LENGTH) {    // 사이즈만큼 뽑았으면
            int channel = Integer.parseInt(makeChannel(selected));
            minDiff = Math.min(minDiff, Math.abs(N-channel));

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (broken.get(i)) continue;    // 고장난 버튼은 못누름
            selected[cnt] = i;
            permutation(cnt+1, selected);
        }
    }

}
