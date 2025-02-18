package SSAFY.study.algo.week70s.week74;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2240_자두나무 {

    static int T, W;
    static int[] dropPositions;

    public static void main(String[] args) throws IOException {
        init();
        calcMaxEat();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        dropPositions = new int[T];
        for (int i = 0; i < T; i++) dropPositions[i] = Integer.parseInt(br.readLine());
    }

    static void calcMaxEat() {
        int[][][] atePlum = new int[T+1][W+1][3]; // 자두가 해당 초에 가지고 있는 목숨 별로, 어느 위치에 서있느 지에 따라 최댓값 저장하고 있는 배열
        atePlum[1][0][1] = (dropPositions[0]==1)?1:0; // 1초 시점에 자두 위치에 따라 목숨 사용했을 때와 안했을 때 최댓값 저장
        atePlum[1][1][2] = (dropPositions[0]==1)?0:1;

        for (int i = 2; i <= T; i++) { // 시간 흐름에 따라
            for (int j = 0; j <= W; j++) { // 각 시간에서의 사용한 목숨 별 카운팅
                atePlum[i][j][1] = Math.max(atePlum[i-1][j][1], atePlum[i-1][j-1][2]);
                atePlum[i][j][2] = Math.max(atePlum[i-1][j-1][1], atePlum[i-1][j][2]);
            }
        }
    }

}
