package BOJ.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드2_19238_스타트택시 {

    static int[] dirRow = new int[] { -1, 0, 0, 1 };    // 상, 좌, 우, 하 -> 승객을 태우는 조건이 거리 다음으로 1. row 우선, 2. col 우선 이어서
    static int[] dirCol = new int[] { 0, -1, 1, 0 };

    static class Taxi {
        int row;
        int col;
        int fuel;
        int takingPassengerIndex;   // 태운 승객의 리스트 상 인덱스

        public Taxi(int row, int col, int fuel, int takingPassengerIndex) {
            this.row = row;
            this.col = col;
            this.fuel = fuel;
            this.takingPassengerIndex = takingPassengerIndex;
        }

        @Override
        public String toString() { return this.row + " " + this.col + " " + this.fuel + " " + this.takingPassengerIndex; }
    }

    static class Passenger {
        int startRow;
        int startCol;
        int endRow;
        int endCol;

        public Passenger(int startRow, int startCol, int endRow, int endCol) {
            this.startRow = startRow;
            this.startCol = startCol;
            this.endRow = endRow;
            this.endCol = endCol;
        }
    }
    static List<Passenger> passengerList;

    static int N, M;
    static int[][] map;
    static int[] startPoint;

    public static void main(String[] args) throws IOException {
        Taxi initTaxi = init();
        doTaxi(initTaxi);
    }

    static Taxi init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int initFuel = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        startPoint = new int[2];
        st = new StringTokenizer(br.readLine());
        startPoint[0] = Integer.parseInt(st.nextToken());
        startPoint[1] = Integer.parseInt(st.nextToken());

        passengerList = new ArrayList<>();
        int startRow, startCol, endRow, endCol;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            startRow = Integer.parseInt(st.nextToken()) - 1;
            startCol = Integer.parseInt(st.nextToken()) - 1;
            endRow = Integer.parseInt(st.nextToken()) - 1;
            endCol = Integer.parseInt(st.nextToken()) - 1;
            passengerList.add(new Passenger(startRow, startCol, endRow, endCol));
        }

        return new Taxi(startPoint[0]-1, startPoint[1]-1, initFuel, -1);
    }

    static void doTaxi(Taxi initTaxi) {

    }



    static boolean isPossibleMove(int row, int col, boolean[][] isVisited) {    // 범위 안이고, 벽이 아니고, 방문한 곳이 아닌 지 체크
        if (!((0 <= row && row < N) && (0 <= col && col < N)) || map[row][col] == 1 || isVisited[row][col]) return false;
        return true;
    }

}
