package BOJ.class2pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_브론즈1_28702_FizzBuzz {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();
        int temp = 0;
        if (Character.isDigit(C.charAt(0))) {   // C가 숫자라면
            temp = Integer.parseInt(C) + 1;
        } else if (Character.isDigit(B.charAt(0))) { // B가 숫자라면
            temp = Integer.parseInt(B) + 2;
        } else if (Character.isDigit(A.charAt(0))) {    // A가 숫자라면
            temp = Integer.parseInt(A) + 3;
        }
        if (temp % 3 == 0 && temp % 5 == 0) System.out.println("FizzBuzz");
        else if (temp % 3 == 0) System.out.println("Fizz");
        else if (temp % 5 == 0) System.out.println("Buzz");
        else System.out.println(temp);
    }

}
