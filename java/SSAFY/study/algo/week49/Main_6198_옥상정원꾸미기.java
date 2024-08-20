package SSAFY.study.algo.week49;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_6198_옥상정원꾸미기 {

    static int N;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        init();
        countCanSee();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
    }

    static void countCanSee() {
        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty()) {
                if (heights[i] < stack.peek()) break;
                stack.pop();
            }
            answer += stack.size();
            stack.push(heights[i]);
        }

        System.out.println(answer);
    }

}
