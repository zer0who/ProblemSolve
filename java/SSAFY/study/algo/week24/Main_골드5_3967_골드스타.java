package SSAFY.study.algo.week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_골드5_3967_골드스타 {

    static String[][] magicStar;

    public static void main(String[] args) throws IOException {
        init();
    }

    static void init() throws IOException {
        magicStar = new String[5][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] row = br.readLine().split("");
            magicStar[i] = row;
        }
    }

}
