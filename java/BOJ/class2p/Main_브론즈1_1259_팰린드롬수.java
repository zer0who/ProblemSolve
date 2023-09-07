package BOJ.class2p;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_브론즈1_1259_팰린드롬수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String answer = "yes";
            String[] input = br.readLine().split("");
            if (input[0].equals("0")) return;
            for (int i = 0; i < input.length/2; i++) {
                if (!input[i].equals(input[input.length-1-i])) {
                    answer = "no";
                    break;
                }
            }
            System.out.println(answer);
        }
    }

}
