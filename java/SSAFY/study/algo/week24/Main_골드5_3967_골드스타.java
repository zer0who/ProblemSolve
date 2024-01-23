package SSAFY.study.algo.week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_골드5_3967_골드스타 {

    static String[][] magicStar;    // 알파벳이 들어가는 인덱스: 0, 4 / 1, 1 . 1, 3 . 1, 5 . 1, 7 / 2, 2 . 2, 6 / 3, 1 . 3, 3 . 3, 5 . 3, 7 / 4, 4

    public static void main(String[] args) throws IOException {
        int initCount = init();
        dfs(initCount, );
    }

    static int init() throws IOException { // . 과 x를 제외한 알파벳들은 우선 숫자로 저장
        int initCount = 0;  // 최초에 입력돼있는 알파벳 개수를 카운트하는 변수
        magicStar = new String[5][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String row = br.readLine();
            for (int j = 0; j < row.length(); j++) {
                if (!String.valueOf(row.charAt(j)).equals(".") && !String.valueOf(row.charAt(j)).equals("x")) initCount += 1;
                magicStar[i][j] = String.valueOf(row.charAt(j));
            }
        }
        
        return initCount;
    }

    static boolean isTwentySix(String[][] drawingStar) {
        
        return false;
    }

    static void dfs(int count, String[][] drawingStar) {    // count: 몇 개의 알파벳을 넣었는지, drawingStar: 그려나가고 있는 매직스타
        if (count == 12) {
            if (isTwentySix(drawingStar)) {
                for (int i = 0; i < 4; i++) System.out.println(Arrays.toString(drawingStar[i]));
            }
        }

        
    }

}
