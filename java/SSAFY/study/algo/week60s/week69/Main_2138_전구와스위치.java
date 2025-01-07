package SSAFY.study.algo.week60s.week69;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2138_전구와스위치 {

    static int N;
    static int[] goalBulb;

    public static void main(String[] args) throws IOException {
        int[] initBulbs = init();
        calcSwitchCount(initBulbs);
    }

    static int[] init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] initBulbs = makeIntArrFromString(br.readLine());
        goalBulb = makeIntArrFromString(br.readLine());

        return initBulbs;
    }

    static int[] makeIntArrFromString(String inputString) { // 입력으로 주어진 문자열을 정수형 배열로 바꾸는 함수
        int[] intArr = new int[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) intArr[i] = Integer.parseInt(String.valueOf(inputString.charAt(i)));

        return intArr;
    }

    static void calcSwitchCount(int[] initBulbs) {
        int[] copiedBulbs = Arrays.copyOf(initBulbs, initBulbs.length); // 나는 doSwitch 함수에서 양옆을 건드리는 게 아니라, 앞으로 연속된 3개를 건드리며 진행함. 그러므로 뒤의 스위치를 다시 조작하는 것은 불가능하므로, 첫 번째 스위치를 건드린 경우는 수동적으로 처리한 배열 하나를 더 두어 따로 처리해줘야 함.
        copiedBulbs[0] = Math.abs(copiedBulbs[0]-1);
        copiedBulbs[1] = Math.abs(copiedBulbs[1]-1);

        int countInitBulbs = 0;
        int countCopiedBulbs = 1;
        for (int i = 0; i < N-1; i++) {   // 첫 번째 전구부터 끝 직전 전구까지 보며 안맞는 전구면 스위치 눌러주고 카운트+1해줌
            if (initBulbs[i] != goalBulb[i]) {
                initBulbs = doSwitch(initBulbs, i);
                countInitBulbs++;
            }
            if (copiedBulbs[i] != goalBulb[i]) {
                copiedBulbs = doSwitch(copiedBulbs, i);
                countCopiedBulbs++;
            }
        }
        if (initBulbs[N-1] != goalBulb[N-1]) countInitBulbs = -1;   // 각 시나리오대로 돌려봤는데 끝 전구가 같지 않다면, 끝 전구를 눌렀을 때 그 앞 전구까지 바뀌므로 goalBulbs처럼 만들 수가 없게 됨.
        if (copiedBulbs[N-1] != goalBulb[N-1]) countCopiedBulbs = -1;

        if (countInitBulbs == -1) System.out.println(countCopiedBulbs); // 둘 중 올바르지 않은 시나리오가 있다면 옳은 시나리오의 전구만 출력
        else if (countCopiedBulbs == -1) System.out.println(countInitBulbs);
        else System.out.println(Math.min(countInitBulbs, countCopiedBulbs));    // 둘 다 만들 수 있는 경우면 두 전구 시나리오 중 스위치 누른 횟수 더 적은 쪽의 횟수 출력
    }

    static int[] doSwitch(int[] bulbs, int index) {
        for (int i = index; i < Math.min(index+3, bulbs.length); i++) bulbs[i] = Math.abs(bulbs[i] - 1);    // 현재 전구의 스위치를 눌렀으니까 연속된 세 개의 전구 상태 바꿔 줌

        return bulbs;
    }

}
