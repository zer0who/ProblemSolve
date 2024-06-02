package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_골드5_27172_수나누기게임 {

    static int N;
    static int[] cards; // 뽑힌 숫자들 그대로 입력 받은 배열
    static int[] numbers;   // 숫자들 마다 점수를 매기기 위한 배열

    public static void main(String[] args) throws IOException {
        init();
        calc();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        numbers = new int[1_000_001];   // 1 ~ 1,000,000 까지 수에 점수를 매길 때 사용
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            cards[index] = Integer.parseInt(st.nextToken());;
            numbers[cards[index]] = index+1;  // 카드 게임에서 뽑힌 숫자들의 값은 0을 넣어줌
            index++;
        }
    }

    static void calc() {
        int[] answer = new int[N+1];  // 점수 저장을 위한 배열
        for (int i = 0; i < N; i++) {
            int card = cards[i];
            for (int j = card*2; j < 1_000_001; j += card) {
                if (numbers[j] > 0) {
                    answer[numbers[card]] += 1;
                    answer[numbers[j]] -= 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i+1]).append(" ");
        }
        System.out.println(sb);
    }

}
