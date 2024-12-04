package SSAFY.study.algo.week60s.week64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_25565_딸기와토마토 {

    static int K;
    static int[][] seeds;
    static int[][] rowSeeds;  // 행에 심어진 씨앗의 시작 열 ~ 끝 열
    static int[][] colSeeds;  // 열에 심어진 씨앗의 시작 행 ~ 끝 행

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < rowSeeds.length; i++) System.out.println(Arrays.toString(rowSeeds[i]));
        System.out.println("==============");
        for (int i = 0; i < colSeeds.length; i++) System.out.println(Arrays.toString(colSeeds[i]));

    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        seeds = new int[N][M];
        rowSeeds = new int[N][2];   // 0: 시작 열, 1: 끝 열
        colSeeds = new int[M][2];   // 0: 시작 행, 1: 끝 행
        for (int i = 0; i < N; i++) Arrays.fill(rowSeeds[i], -1);   // 안헷갈리게 -1로 초기화
        for (int i = 0; i < M; i++) Arrays.fill(colSeeds[i], -1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            boolean started = false;
            boolean ended = false;
            for (int j = 0; j < M; j++) {
                seeds[i][j] = Integer.parseInt(st.nextToken());
                if (seeds[i][j] == 1 && !started) {
                    rowSeeds[i][0] = j;   // 아직 그 행의 시작 씨앗이 안나온 상태에서 이번 칸이 씨앗이면 시작 좌표 표시
                    started = true;
                }
                if (started && seeds[i][j] == 0 && !ended) {
                    rowSeeds[i][1] = j-1;  // 시작 씨앗이 나온 상태에서 이번 칸이 빈 땅이면 그 전 좌표가 끝좌표임을 표시
                    ended = true;
                }
            }
            if (started && !ended) rowSeeds[i][1] = M-1;   // 만약 끝까지 뿌린 경우라면 끝까지 뿌렸음을 표시
        }

        for (int j = 0; j < M; j++) {
            boolean started = false;
            boolean ended = false;
            for (int i = 0; i < N; i++) {
                if (seeds[i][j] == 1 && !started) {
                    colSeeds[j][0] = i;   // 아직 그 행의 시작 씨앗이 안나온 상태에서 이번 칸이 씨앗이면 시작 좌표 표시
                    started = true;
                }
                if (started && seeds[i][j] == 0 && !ended) {
                    colSeeds[j][1] = i-1;  // 시작 씨앗이 나온 상태에서 이번 칸이 빈 땅이면 그 전 좌표가 끝좌표임을 표시
                    ended = true;
                }
            }
            if (started && !ended) colSeeds[j][1] = N-1;   // 만약 끝까지 뿌린 경우라면 끝까지 뿌렸음을 표시
        }
    }

    static void findAxis() {
        PriorityQueue<int[]> pq = new PriorityQueue<>();
        int rowCount = 0;
        List<Integer> rowNumber = new ArrayList<>();
        int colCount = 0;
        for (int i = 0; i < rowSeeds.length; i++) {
            if (rowSeeds[i][1] - rowSeeds[i][0] + 1 == K) rowCount++;
        }
    }

}
