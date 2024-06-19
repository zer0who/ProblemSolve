package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main_골드4_9252_LCS2 {

    static String A, B;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
    }

    static void solve() {
        StringBuilder sb = new StringBuilder();
        int[][] dpArr = new int[B.length()+1][A.length()+1];
        for (int i = 1; i < B.length() + 1; i++) {  // B를 한 글자씩 늘려가며 행 값으로, A의 각 문자를 열 값으로 생각하며 dp에 최장 값 저장(LCS1 풀이 때는 1차원 배열만을 사용했었음)
            char b = B.charAt(i-1);
            for (int j = 1; j < A.length() + 1; j++) {
                char a = A.charAt(j-1);
                if (String.valueOf(b).equals(String.valueOf(a))) {  // 같은 문자라면 2차원 테이블로 표현했을 때 대각선 왼쪽 위의 값 + 1을 저장해 줌.
                    dpArr[i][j] = dpArr[i-1][j-1] + 1;
                } else {    // 같은 문자가 아니라면, 2차원 테이블로 표현했을 때 위, 왼쪽 중 최댓 값을 저장
                    dpArr[i][j] = Math.max(dpArr[i][j-1], dpArr[i-1][j]);
                }
            }
        }
        sb.append(dpArr[B.length()][A.length()]).append("\n");   // 우선 최장 길이 값 저장
        int row = B.length();
        int col = A.length();
        int now = dpArr[B.length()][A.length()];    // 맨 오른쪽 아래 수부터 문자 저장 시작
        Stack<Character> stack = new Stack<Character>();    // 뒤에서부터 탐색이므로 역으로 뽑아낼 때 정답이 되게끔 스택으로 저장
        while ((row > 0 && col > 0) && now > 0) {
            if (dpArr[row][col-1] == now) col -= 1;
            else if (dpArr[row-1][col] == now) row -= 1;
            else {
                row -= 1;
                col -= 1;
                now -= 1;
                stack.push(B.charAt(row));
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
    }

}
