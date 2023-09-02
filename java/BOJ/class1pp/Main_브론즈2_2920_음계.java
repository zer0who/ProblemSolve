package BOJ.class1pp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_브론즈2_2920_음계 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        String[] input = br.readLine().split(" ");
        for (int i = 1; i < input.length; i++) {
            if (Integer.parseInt(input[i]) - Integer.parseInt(input[i-1]) > 0) {
                if (answer.equals("descending")) {
                    answer = "mixed";
                    break;
                }
                answer = "ascending";
            } else if (Integer.parseInt(input[i]) - Integer.parseInt(input[i-1]) < 0) {
                if (answer.equals("ascending")) {
                    answer = "mixed";
                    break;
                }
                answer = "descending";
            }
        }
        System.out.println(answer);
    }

}
