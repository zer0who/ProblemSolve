package BOJ.class2pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_실버2_18111_마인크래프트 {

    private static int minTime; // 가장 적게 걸린 시간
    private static int highestLand;    // 가장 작은 시간이 걸린 것 중 최고 높이
    private static int minHeight;   // 가장 낮은 땅 높이
    private static int maxHeight;   // 가장 높은 땅 높이
    private static int N, M; // NxM 땅
    private static long B;  // 처음 인벤토리 블록 수 B
    private static int[][] landHeight;


    public static void main(String[] args) throws Exception {
        init();
        findAnswer();
        System.out.println(minTime + " " + highestLand);

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        minTime = Integer.MAX_VALUE;
        highestLand = 0;
        minHeight = Integer.MAX_VALUE;
        maxHeight = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        landHeight = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int inputHeight = Integer.parseInt(st.nextToken());
                landHeight[i][j] = inputHeight;
                if (inputHeight < minHeight) minHeight = inputHeight;
                if (inputHeight > maxHeight) maxHeight = inputHeight;
            }
        }
    }

    private static void findAnswer() {
        int h = minHeight;
        while (h <= maxHeight) { // 최소 높이와 최대 높이 사이의 값에 대해서 땅고르기를 해본다.
//            System.out.println("======OG=========");
//            for (int i = 0; i < N; i++) System.out.println(Arrays.toString(landHeight[i]));
            landLeveling(h);
//            System.out.println("=================");
//            System.out.println("=================");
//            System.out.println("=================");
            h += 1;
        }
    }

    private static void landLeveling(int h) {
        int tempTime = 0;
        long tempBlock = B;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int nowHeight = landHeight[i][j];
                if (nowHeight > h) { // 현재 땅보다 높으면, 땅 파고 B 추가, 시간은 2초 추가
                    int heightDiff = nowHeight - h;
                    tempBlock += heightDiff;
                    tempTime += 2*heightDiff;
                } else {  // 현재 땅보다 낮으면, B에서 꺼내서 땅 채우고, 시간은 1초 추가
                    int heightDiff = h - nowHeight;
                    tempBlock -= heightDiff;

                    tempTime += heightDiff;
                }
            }
        }

//        System.out.println("======LEVELED=========");
//        for (int i = 0; i < N; i++) System.out.println(Arrays.toString(copiedLand[i]));
        if (tempBlock < 0) return;  // 인벤토리 블록이 음수면 잘못된 경우이므로 불가능한 경우 -> 함수 종료(순서가 정해진 게 아니므로, 전체 땅에 대해서 작업을 완료한 뒤 음수 여부 판단해야함)

        if (tempTime <= minTime) {   // 가장 짧은 시간이 걸린 작업인지 판단
            minTime = tempTime;
            highestLand = h;    // 어차피 높이 순으로 하면, 시간 갱신될 때 높이도 자동으로 최고 높이가 됨.
//            System.out.println("갱신 with " + minTime + " " + highestLand);
        }
    }

}
