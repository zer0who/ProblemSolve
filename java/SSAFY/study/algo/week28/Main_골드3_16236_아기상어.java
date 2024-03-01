package SSAFY.study.algo.week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드3_16236_아기상어 {

    static int[] dirRow = new int[]{-1, 1, 0, 0};  // 상 하 좌 우
    static int[] dirCol = new int[]{0, 0, -1, 1};

    static class Shark {
        int row;
        int col;
        int size;
        int eatCount;   // 자기 크기만큼 물고기를 먹어야 사이즈 1 증가
        int time;   // 먹이 먹은 시간

        public Shark(int row, int col, int size, int eatCount, int time) {
            this.row = row;
            this.col = col;
            this.size = size;
            this.eatCount = eatCount;
            this.time = time;
        }

        @Override
        public String toString() {
            return this.row + " " + this.col + " " + this.size;
        }
    }

    static class Fish {
        int row;
        int col;
        int size;

        public Fish(int row, int col, int size) {
            this.row = row;
            this.col = col;
            this.size = size;
        }

        @Override
        public String toString() {
            return this.row + " " + this.col + " " + this.size;
        }
    }

    static int N;
    static int[][] map; // 물고기 크기 정보 저장용
    static Shark shark;


    public static void main(String[] args) throws IOException {
        init();
        doEat();
        System.out.println(shark.time);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int mapInfo = Integer.parseInt(st.nextToken());
                if (mapInfo == 9) {
                    shark = new Shark(i, j, 2, 0, 0);   // 최초 상어 크기는 2
                    map[i][j] = 0;  // 상어 자신은 맵에 표시하지 않음
                    continue;
                }
                map[i][j] = mapInfo;
            }
        }
    }

    static boolean isOuted(int row, int col) {
        if ((0 <= row && row < N) && (0 <= col && col < N)) return false;
        return true;
    }

    static void convertShark(Fish eatFish) {
        shark.time += Math.abs(shark.row - eatFish.row) + Math.abs(shark.col - eatFish.col);
        shark.row = eatFish.row;
        shark.col = eatFish.col;
        shark.eatCount += 1;
        if (shark.eatCount == shark.size) {
            shark.size += 1;
            shark.eatCount = 0;
        }
    }

    static void doEat() {
        PriorityQueue<Fish> pq = new PriorityQueue<>(new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                // compare 함수 다시 정의
            }
        });
        Queue<Shark> queue = new ArrayDeque<>();
        queue.offer(shark); // 먹이를 먹으러 출발하는 시점의 상어

        while (true) {  // 먹을 수 있는 먹이가 있는 동안 반복
            // 1. bfs이용, pq에 먹을 수 있는 먹이 추가
            boolean[][] isVisited = new boolean[N][N];
            isVisited[shark.row][shark.col] = true;

            while (!queue.isEmpty()) {
                Shark nowShark = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nextRow = nowShark.row + dirRow[d];
                    int nextCol = nowShark.col + dirCol[d];
                    if (isOuted(nextRow, nextCol) || isVisited[nextRow][nextCol] || map[nextRow][nextCol] > shark.size)
                        continue;  // 범위 밖이거나 방문한 곳, 상어보다 큰 물고기가 있는 곳이라면 continue
                    // pq에 먹이 넣는 로직 다시(현재 상어 위치에서 이동한 카운트만큼이 걸리는 거리임, 맨해튼 거리 x)
                }
            }
            // 먹이 먹는 로직 다시
        }
    }
}
