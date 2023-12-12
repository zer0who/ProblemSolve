package SSAFY.study.algo.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_골드5_20165_인내의도미노장인호석 {

    static Map<String, Integer> dirMap = new HashMap<>(4);  // N: 0, S: 1, W: 2, E: 3

    static int N, M, R;
    static int[][] dominoes;
    static boolean[][] isDowned;    // 도미노 넘어져있는지 상태 저장용 배열(true: 넘어짐, false: 서 있음)
    static int[][] attackActions;
    static int[][] defenceActions;
    static int score;   // 공격의 점수

    public static void main(String[] args) throws IOException {
        init();
        for (int r = 0; r < R; r++) {
            doAttack(r);
            doDefence(r);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(score).append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isDowned[i][j]) sb.append("F").append(" ");
                else sb.append("S").append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void init() throws IOException {
        dirMap.put("N", 0);
        dirMap.put("S", 1);
        dirMap.put("W", 2);
        dirMap.put("E", 3);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        dominoes = new int[N][M];
        isDowned = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                dominoes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        attackActions = new int[R][3];  // 공격: [[N, M, D], ... ]
        defenceActions = new int[R][2]; // 수비: [[N, M], ... ]
        for (int i = 0; i < R; i++) {
            // 공격 입력
            st = new StringTokenizer(br.readLine());
            attackActions[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), dirMap.get(st.nextToken())};
            // 수비 입력
            st = new StringTokenizer(br.readLine());
            defenceActions[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        score = 0;
    }

    static void doAttack(int r) {   // r: 라운드
        int[] attack = attackActions[r];
    }

    static void doDefence(int r) {  // r: 라운드
        int[] defence = defenceActions[r];
    }

}
