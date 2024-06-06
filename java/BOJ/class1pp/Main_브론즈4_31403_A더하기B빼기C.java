package BOJ.class1pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_브론즈4_31403_A더하기B빼기C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A, B, C;
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        System.out.println(A + B - C);
        System.out.println(Integer.parseInt(String.valueOf(A) + B) - C);
    }

}
