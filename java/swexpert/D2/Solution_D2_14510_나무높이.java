package swexpert.D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D2_14510_나무높이 {

    private static StringBuilder sb = new StringBuilder();
    private static int N;   // 나무 개수
    private static int[] trees; // 나무 배열
    private static int highest;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("/Users/yeonghukim/PS/ProblemSolve/java/swexpert/D2/files/14510_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            initTrees(br);
            Arrays.sort(trees); // 나무 높이순 정렬
            highest = trees[N-1];   // 가장 높이가 높은 나무의 높이 저장
            int day = 1;    // 날짜 카운트
            while (trees[0] != highest) {   // 나무들 높이가 다 같아질 때까지
                if (day % 2 == 1) { // 홀수 날 => 나무 높이 1증가
                    if (trees[1] == highest) {  // 물 줘야할 나무가 한 개 남았을 때
                        if ((highest - trees[0]) != 2) {    // 높이 딱 2남은 거 아니면 물 주면 됨
                            trees[0] += 1;
                            continue;
                        }
                    }


                } else if (day % 2 == 0){    // 짝수 날 => 나무 높이 2증가
                    if (trees[1] == highest) {  // 물 줘야할 나무가 한 개 남았을 때
                        if ((highest - trees[0]) > 2) {    // 높이 딱 2남은 거 아니면 물 주면 됨
                            trees[0] += 2;
                            continue;
                        }
                    }


                }
                Arrays.sort(trees); // 나무 높이순 정렬
                day += 1;
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void initTrees(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        trees = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
    }

}
