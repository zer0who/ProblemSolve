package BOJ.class2pp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_브론즈2_15829_Hashing {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String input = br.readLine();
        System.out.println(hash(L, input));

    }

    private static long hash(int L, String input) {
        long res = 0;
        long powNum = 1;
        for (int i = 0; i < L; i++) {
            int num = input.charAt(i)-96;
            res += (num*powNum);
            powNum = (powNum*31)%1234567891;
        }

        return res%1234567891;
    }

}
