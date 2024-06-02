package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_골드5_2467_용액 {

    static int N;
    static int[] liquids;   // 용액 배열, 정렬된 채로 주어짐.

    public static void main(String[] args) throws IOException {
        init();
        findMinDiff();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        liquids = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            liquids[index++] = Integer.parseInt(st.nextToken());
        }
    }

    static void findMinDiff() {
        int[] answerLiquids = new int[2];
        int minDiff = Integer.MAX_VALUE;
        int leftIndex = 0;
        int rightIndex = N-1;
        int tempDiff;
        while (leftIndex < rightIndex) {
            tempDiff = liquids[leftIndex] + liquids[rightIndex];
            if (Math.abs(tempDiff) <= minDiff) {   // 0에 가까운 값이 갱신됐을 때
                minDiff = Math.abs(tempDiff);
                answerLiquids[0] = liquids[leftIndex];
                answerLiquids[1] = liquids[rightIndex];
                if (minDiff == 0) break;    // 용액 합이 0이면 바로 정답 처리
            }
            if (tempDiff > 0) rightIndex--;
            else if (tempDiff <= 0) leftIndex++;
        }
        System.out.println(answerLiquids[0] + " " + answerLiquids[1]);
    }

}
