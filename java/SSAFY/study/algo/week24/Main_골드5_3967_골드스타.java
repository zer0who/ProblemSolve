package SSAFY.study.algo.week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_골드5_3967_골드스타 {

    static String[][] magicStar;

    public static void main(String[] args) throws IOException {
        init();
        dfs();
    }

    static void init() throws IOException { // . 과 x를 제외한 알파벳들은 우선 숫자로 저장
        magicStar = new String[5][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String row = br.readLine();
            for (int j = 0; j < row.length(); j++) {
                if (!String.valueOf(row.charAt(j)).equals("x") && !String.valueOf(row.charAt(j)).equals(".")) magicStar[i][j] = String.valueOf(row.charAt(j) - 64); // A부터 1이니 64만 빼줌
                else magicStar[i][j] = String.valueOf(row.charAt(j));
            }
        }
    }

    static void dfs() {

    }

}
