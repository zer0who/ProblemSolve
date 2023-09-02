package BOJ.class1pp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_브론즈5_2475_검증수 {

    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String[] input = br.readLine().split(" ");
        for (String n : input) {
            answer += Math.pow(Integer.parseInt(n), 2);
        }
        System.out.println(answer%10);
    }

}
