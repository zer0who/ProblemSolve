package SSAFY.study.algo.week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_골드5_3967_골드스타 {

    static String[][] magicStar;
    static int[][] alphabetAxis;    // 알파벳이 들어가는 인덱스: 0, 4 / 1, 1 . 1, 3 . 1, 5 . 1, 7 / 2, 2 . 2, 6 / 3, 1 . 3, 3 . 3, 5 . 3, 7 / 4, 4
    static boolean[] usedAlphabet;  // 1부터 12까지 쓴 알파벳 체크

    public static void main(String[] args) throws IOException {
        init();
//        dfs(initCount, );
    }

    static void init() throws IOException { // . 과 x를 제외한 알파벳들은 우선 숫자로 저장
        magicStar = new String[5][9];
        alphabetAxis = new int[12][2];
        usedAlphabet = new boolean[13];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int axisIndex = 0;  // 알파벳 좌표를 입력하기 위한 변수
        for (int i = 0; i < 5; i++) {
            String row = br.readLine();
            for (int j = 0; j < row.length(); j++) {
                if (!String.valueOf(row.charAt(j)).equals(".")) {
                    if (!String.valueOf(row.charAt(j)).equals("x")) usedAlphabet[Integer.parseInt(String.valueOf(row.charAt(j) - 64))] = true;
                    alphabetAxis[axisIndex] = new int[] {i, j};
                    axisIndex += 1;
                }
                magicStar[i][j] = String.valueOf(row.charAt(j));
            }
        }
    }

    static boolean isTwentySix(String[][] drawingStar) {    // 모든 줄의 합이 26인지 체크
        if (Integer.parseInt(drawingStar[0][4]) + Integer.parseInt(drawingStar[1][3]) + Integer.parseInt(drawingStar[2][2]) + Integer.parseInt(drawingStar[3][1]) != 26) return false;
        if (Integer.parseInt(drawingStar[0][4]) + Integer.parseInt(drawingStar[1][5]) + Integer.parseInt(drawingStar[2][6]) + Integer.parseInt(drawingStar[3][7]) != 26) return false;
        if (Integer.parseInt(drawingStar[3][1]) + Integer.parseInt(drawingStar[3][3]) + Integer.parseInt(drawingStar[3][5]) + Integer.parseInt(drawingStar[3][7]) != 26) return false;
        if (Integer.parseInt(drawingStar[4][4]) + Integer.parseInt(drawingStar[3][3]) + Integer.parseInt(drawingStar[2][2]) + Integer.parseInt(drawingStar[1][1]) != 26) return false;
        if (Integer.parseInt(drawingStar[4][4]) + Integer.parseInt(drawingStar[3][5]) + Integer.parseInt(drawingStar[2][6]) + Integer.parseInt(drawingStar[1][1]) != 26) return false;

        return Integer.parseInt(drawingStar[1][1]) + Integer.parseInt(drawingStar[1][3]) + Integer.parseInt(drawingStar[1][5]) + Integer.parseInt(drawingStar[1][7]) == 26;
    }

    static void dfs(int count, String[][] drawingStar) {    // count: 몇 개의 알파벳을 넣었는지, drawingStar: 그려나가고 있는 매직스타
        if (count == 12) {
            if (isTwentySix(drawingStar)) {
                for (int i = 0; i < 4; i++) System.out.println(Arrays.toString(drawingStar[i]));
            }

            return;
        }

        for (int i = 0; i < usedAlphabet.length; i++) {

        }
        
    }

}
