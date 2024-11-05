package SSAFY.study.algo.week60;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1662_압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int index = 0;
        String answer = "";
        while (index < input.length()) {
            String unzipped = unzip(input, index);
            answer += unzipped;
            while (index < input.length()) {
                if (input.charAt(index) == ')') {
                    index++;
                    break;
                }
                index++;
            }
        }
        System.out.println(answer.length());
    }

    static String unzip(String input, int startIndex) {
        String temp = "";
        for (int i = startIndex; i < input.length(); i++) {  // 현재 시작 인덱스부터 시작하여서
            if (i < input.length()-1 && input.charAt(i + 1) == '(') {   // 현재 숫자 다음 문자가 (인 경우
                int repeater = Integer.parseInt(String.valueOf(input.charAt(i)));
                if (repeater == 0) return temp;  // 근데 괄호 앞에 숫자가 0이면 빈 문자열로

                String t = unzip(input, i+2);
                String t2 = t;
                for (int j = 0; j < repeater-1; j++) t += t2;   // 현재 숫자 횟수만큼 문자열 연속되게 만들어줌

                return temp + t;
            }
            if (input.charAt(i) == ')') return temp;    // 기저, ) 를 만난 경우, temp를 리턴해줌
            if (input.charAt(i) != '(') temp += String.valueOf(input.charAt(i));    // 그 외의 경우는 temp에 문자를 계속 쌓아줌.
        }

        return temp;
    }

}
