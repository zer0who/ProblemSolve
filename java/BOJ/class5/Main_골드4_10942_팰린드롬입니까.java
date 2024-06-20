package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_골드4_10942_팰린드롬입니까 {

    static int N, M;
    static int[] numbers;
    static int[][] palindrome;  // i~j가 팰린드롬인지 여부 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        doGame(br);
    }

    static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N+1];
        palindrome = new int[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 1; j < N+1; j++) { // 입력받으면서 팰린드롬 여부 저장, j: 열
            numbers[j] = Integer.parseInt(st.nextToken());
            for (int i = 1; i < j+1; i++) { // i: 행. 헷갈리지 말 것
                if (i == j) palindrome[i][j] = 1;   // 한 자리 수는 팰린드롬 처리
                else if (j == i+1) { if (numbers[i] == numbers[j]) palindrome[i][j] = 1; }   // 한 칸 차이날 때는 두 수가 같은 수여야 팰린드롬임
                else {
                    if (numbers[i] == numbers[j] && palindrome[i+1][j-1] == 1) palindrome[i][j] = 1;    // 그 외의 경우는 입력으로 받은 수가 같아야 하고, 그 사이에 낀 수가 팰린드롬이어야 함.
                }
            }
        }
        M = Integer.parseInt(br.readLine());
    }

    static void doGame(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        int S, E;
        StringTokenizer st;
        for (int i = 0; i < M; i++) {   // M개의 질문 동안 팰린드롬 여부 확인
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            sb.append(palindrome[S][E]).append("\n");
        }
        System.out.println(sb);
    }

}
