package swexpert.SWtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_Cooker {

    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] aFoods;
    private static int[][] synergy;
    private static int min;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/yeonghukim/IdeaProjects/ssafy/work_algorithm/230807w/4012_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            aFoods = new int[N/2];
            synergy = new int[N][N];
            initSynergy(br, N); // 시너지 초기화

            combination(0, 0);

            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void initSynergy(BufferedReader br, int N) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                synergy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void combination(int cnt, int start) {
        if (cnt == N/2) {   // A 재료 다 담았으면
            int[] bFoods = new int[N/2]; //  나머지 재료들 B에 쓰게 저장
            int bIdx = 0;
            for (int i = 0; i < N; i++) {
                boolean isSelected = false;
                for (int j = 0; j < N/2; j++) {
                    if (i == aFoods[j]) {
                        isSelected = true;
                        break;
                    }
                }
                if (!isSelected) bFoods[bIdx++] = i;    // A에 안쓴 음식이면 B에 쓰기
            }

            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < N/2-1; i++) {   // 시너지 계산
                for (int j = i; j < N/2; j++) {
                    sumA += synergy[aFoods[i]][aFoods[j]] + synergy[aFoods[j]][aFoods[i]];
                    sumB += synergy[bFoods[i]][bFoods[j]] + synergy[bFoods[j]][bFoods[i]];
                }
            }

            int subAB = Math.abs(sumA - sumB);
            if (subAB < min) min = subAB;

            return;
        }

        for (int i = start; i < N; i++) {
            aFoods[cnt] = i;
            combination(cnt+1, i+1);
        }
    }

}
