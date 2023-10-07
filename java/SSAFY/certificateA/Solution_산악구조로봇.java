package SSAFY.certificateA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_산악구조로봇 {

    static int[] dirRow = new int[] {-1, 1, 0, 0};  // 상, 하, 좌, 우
    static int[] dirCol = new int[] {0, 0, -1, 1};

    static class Mrobot implements Comparable<Mrobot> {   // 산악구조로봇 클래스
        int row;
        int col;
        int height; // 로봇의 위치에서의 높이
        int fuel;   // 로봇의 위치까지 든 연료

        public Mrobot(int row, int col, int height, int fuel) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public String toString() {
            return this.row + " " + this.col + " " + this.height + " " + this.fuel;
        }

        @Override
        public int compareTo(Mrobot o) {    // priority queue에서 우선순위 비교에 쓰일 비교 함수
            return Integer.compare(this.fuel, o.fuel);
        }
    }

    static int N;
    static int[][] mountain;
    static int[][] fuelUsed;    // 해당 경로까지 든 연료 비용의 최소값 저장할 배열

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            init(br);
            Mrobot initMrobot = new Mrobot(0, 0, mountain[0][0], 0);
            dijkstra(initMrobot);

            sb.append(fuelUsed[N-1][N-1]).append("\n");
        }
        System.out.println(sb);
    }

    static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        mountain = new int[N][N];
        fuelUsed = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mountain[i][j] = Integer.parseInt(st.nextToken());
                fuelUsed[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    static boolean isOuted(int row, int col) {
        if ((0 <= row && row < N) && (0 <= col && col < N)) return false;

        return true;
    }

    static int calcFuel(int nowH, int nextH) {
        int useFuel = 0;    // 다음 높이가 현재 높이보다 낮으면 사용한 연료 0 고정
        if (nextH > nowH) useFuel = 2 * (nextH - nowH);
        else if (nextH == nowH) useFuel = 1;

        return useFuel;
    }

    static void dijkstra(Mrobot initMrobot) {
        PriorityQueue<Mrobot> pq = new PriorityQueue<>();
        pq.offer(initMrobot);
        fuelUsed[0][0] = 0;

        while(!pq.isEmpty()) {
            Mrobot nowRobot = pq.poll();
            int nowR = nowRobot.row;
            int nowC = nowRobot.col;
            int nowH = nowRobot.height;
            int nowF = nowRobot.fuel;

            if (nowF > fuelUsed[nowR][nowC]) continue;  // -> 방문처리를 이런 식으로.(여기까지 오는 데 든 연료가 최소 연료비용보다 크다면, 최단 거리 갱신이랑 거리가 멀어지므로 주변탐색 안하고 건너 뜀)
            for (int i = 0; i < 4; i++) {
                int nextR = nowR + dirRow[i];
                int nextC = nowC + dirCol[i];
                if (!isOuted(nextR, nextC)) {
                    int useFuel = calcFuel(nowH, mountain[nextR][nextC]);
                    if (fuelUsed[nextR][nextC] > fuelUsed[nowR][nowC] + useFuel) {
                        fuelUsed[nextR][nextC] = fuelUsed[nowR][nowC] + useFuel;

                        pq.offer(new Mrobot(nextR, nextC, mountain[nextR][nextC], fuelUsed[nextR][nextC]));
                    }
                }
            }
        }
    }

}
