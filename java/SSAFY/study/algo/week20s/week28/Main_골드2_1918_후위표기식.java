package SSAFY.study.algo.week20s.week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_골드2_1918_후위표기식 {

    static char[] expression;

    public static void main(String[] args) throws IOException {
        init();
        changeExpression();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        expression = br.readLine().toCharArray();
    }

    private static int priority(Character op) { // 연산자 우선 순위 매기는 함수
        if(op=='(' || op==')') return 0;
        else if(op=='+' || op=='-') return 1;
        else return 2;
    }

    static void changeExpression() {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : expression) {
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) sb.append(stack.pop());
                    stack.add(c);
                    break;
                case '(':
                    stack.add(c);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '(')
                        sb.append(stack.pop());
                    if(!stack.isEmpty())
                        stack.pop();
                    break;
                default:
                    sb.append(c);
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
    }

}
