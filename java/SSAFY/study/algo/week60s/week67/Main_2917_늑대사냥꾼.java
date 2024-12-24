package SSAFY.study.algo.week60s.week67;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2917_늑대사냥꾼 {

    static class Hyunwoo implements Comparable<Hyunwoo> {
        int row;
        int col;
        int distToTree; // 나무까지의 거리 중 최솟값

        public Hyunwoo(int row, int col, int distToTree) {
            this.row = row;
            this.col = col;
            this.distToTree = distToTree;
        }

        @Override
        public int compareTo(Hyunwoo h) {
            return h.distToTree - this.distToTree;  // 나무까지 거리 최솟값에 대해 내림차순 정렬
        }
    }

    static int N, M;
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        int[] startPoint = init();

    }

    static int[] init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new char[N][M];
        int[] startPoint = new int[2];
        String inputRow;
        for (int i = 0; i < N; i++) {
            inputRow = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = inputRow.charAt(j);
                if (grid[i][j] == 'V') startPoint = new int[] {i, j};
            }
        }

        return startPoint;
    }

    static void calcMinDist(int[] startPoint) {
        PriorityQueue<Hyunwoo> pq = new PriorityQueue<>();
        pq.offer(new Hyunwoo(startPoint[0], startPoint[1], 0));
    }

}
