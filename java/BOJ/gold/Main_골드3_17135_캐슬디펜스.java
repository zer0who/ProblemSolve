package BOJ.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드3_17135_캐슬디펜스 {

    static class Enemy {
        int row;
        int col;

        public Enemy(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return this.row + " " + this.col;
        }
    }

    static int N, M, D; // D: 궁수의 공격 거리
    static int[][] grid;
    static List<Enemy> originEnemyList;
    static int maxKilled;

    public static void main(String[] args) throws IOException {
        init();
        combination(0, 0, new int[3]);
        System.out.println(maxKilled);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        originEnemyList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) originEnemyList.add(new Enemy(i, j));    // 적이라면 적 리스트에 추가
            }
        }
        maxKilled = 0;
    }

    static void combination(int depth, int start, int[] selected) { // 궁수를 위치 시킬 세 군데를 구함
        if (depth == 3) {   // 기저, 세 명을 배치시킬 곳을 모두 정했을 경우
            castleDefence(selected);
            return;
        }

        for (int i = start; i < M; i++) {
            selected[depth] = i;
            combination(depth + 1, i + 1, selected);
        }
    }

    static void castleDefence(int[] selected) { // 정해진 궁수의 위치에서 캐슬 디펜스 시뮬레이션 수행

    }

}
