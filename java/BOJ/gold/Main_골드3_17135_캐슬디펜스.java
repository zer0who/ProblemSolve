package BOJ.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드3_17135_캐슬디펜스 {

    static class Enemy {
        int row;
        int col;
        boolean isKilled;

        public Enemy(int row, int col, boolean isKilled) {
            this.row = row;
            this.col = col;
            this.isKilled = isKilled;
        }

        @Override
        public String toString() {
            return this.row + " " + this.col + " " + isKilled;
        }
    }

    static int N, M, D; // D: 궁수의 공격 거리
    static int[][] grid;
    static List<Enemy> originEnemyList;
    static int maxKilled;

    public static void main(String[] args) throws IOException {
        init();
        combination(0, 0, new boolean[M]);
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
                if (grid[i][j] == 1) originEnemyList.add(new Enemy(i, j, false));    // 적이라면 적 리스트에 추가
            }
        }
        maxKilled = 0;
    }

    static void combination(int depth, int start, boolean[] selected) { // 궁수를 위치 시킬 세 군데를 구함
        if (depth == 3) {   // 기저, 세 명을 배치시킬 곳을 모두 정했을 경우
            List<Enemy> enemyList = new ArrayList<>();   // 해당 시뮬레이션에서만 사용할 새 리스트 생성
            for (int i = 0; i < originEnemyList.size(); i++) {
                Enemy nowEnemy = originEnemyList.get(i);
                enemyList.add(new Enemy(nowEnemy.row, nowEnemy.col, false));
            }
            castleDefence(selected, enemyList);
            return;
        }

        for (int i = start; i < M; i++) {
            selected[i] = true;
            combination(depth + 1, i + 1, selected);
            selected[i] = false;
        }
    }

    static void castleDefence(boolean[] selected, List<Enemy> enemyList) { // 정해진 궁수의 위치에서 캐슬 디펜스 시뮬레이션 수행
        int killedCount = 0;

        while (enemyList.size() > 0) {  // 격자 상 모든 적이 없어질 때까지
            for (int i = 0; i < M; i++) {   // 궁수들이 설 수 있는 위치에 대해서
                if (!selected[i]) continue; // 궁수가 서있지 않은 곳은 건너뜀

                int minDist = Integer.MAX_VALUE;    // 궁수가 공격할 수 있는 적 중 가장 가까운 적과의 거리 선별
                int minIndex = -1;  // 그때의 적의 리스트 상 인덱스
                for (int j = 0; j < enemyList.size(); j++) {
                    Enemy nowEnemy = enemyList.get(j);
                    int nowDist = Math.abs(nowEnemy.row - N) + Math.abs(nowEnemy.col - i);
                    if (nowDist <= D) {  // 공격 가능한 거리 내에 적이 위치한 경우
                        if (minDist > nowDist) {    // 그 적이 가장 근거리에 존재하는 적인 경우, 바로 갱신
                            minDist = nowDist;
                            minIndex = j;
                        } else if (minDist == nowDist && nowEnemy.col < enemyList.get(minIndex).col) minIndex = j;  // 현재까지 최소 거리와 같지만 더 왼쪽에 있는 적인 경우 갱신
                    }
                }

                if (minIndex != -1) enemyList.get(minIndex).isKilled = true;    // 한 궁수의 마지막 절차는 공격 대상 공격 처리
            }
            List<Enemy> nextEnemyList = new ArrayList<>();
            for (int i = 0; i < enemyList.size(); i++) {
                Enemy nowEnemy = enemyList.get(i);
                if (nowEnemy.isKilled) killedCount++;    // 죽은 적은 카운트 후 리스트에 다시 넣지 않음
                else if (!nowEnemy.isKilled && nowEnemy.row + 1 < N) nextEnemyList.add(new Enemy(nowEnemy.row + 1, nowEnemy.col, false));    // 죽지 않았고 격자 밖을 벗어나지 않은 적은 리스트에 다시 넣음
            }
            enemyList = new ArrayList<>(nextEnemyList); // 적 리스트 새로운 리스트로 갱신
        }

        maxKilled = Math.max(maxKilled, killedCount);
    }

}
