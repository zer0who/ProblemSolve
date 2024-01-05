package SSAFY.study.algo.week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_골드4_1504_특정한최단경로 {

    static class Sejun implements Comparable<Sejun> {
        int from;
        int to;
        int totalDist;
        boolean[] havePassed;   // 반드시 지나야하는 두 점을 지났는지 체크할 필드

        public Sejun(int from, int to, int totalDist, boolean[] havePassed) {
            this.from = from;
            this.to = to;
            this.totalDist = totalDist;
            this.havePassed = havePassed;
        }

        @Override
        public int compareTo(Sejun o) {
            return this.totalDist - o.totalDist;
        }
    }

    static int N, E;
    static int[][] distArr;
    static int must1, must2;
    static int answer;

    public static void main(String[] args) throws IOException {
        init();
        dijkstra();
        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distArr = new int[N+1][N+1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            distArr[from][to] = dist;
            distArr[to][from] = dist;
        }
        st = new StringTokenizer(br.readLine());
        must1 = Integer.parseInt(st.nextToken());
        must2 = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
    }

    static void dijkstra() {
        int[] minimumDist = new int[N+1];
        Arrays.fill(minimumDist, Integer.MAX_VALUE);
        PriorityQueue<Sejun> pq = new PriorityQueue<>();
        for (int i = 1; i < N+1; i++) {
            if (distArr[1][i] == 0) continue;   // 출발점에서 이어지지 않은 곳은 패스
            pq.offer(new Sejun(1, i, distArr[1][i], new boolean[2]));
            minimumDist[i] = distArr[1][i];
        }

        while (!pq.isEmpty()) {
            Sejun now = pq.poll();
            System.out.println(Arrays.toString(minimumDist));
            if (now.to == N) {
                if (!(now.havePassed[0] && now.havePassed[1])) continue;    // 반드시 거쳐야하는 두 점을 안거쳤으면 다음 반복문으로
                answer = Math.min(answer, now.totalDist);
            }

            for (int i = 1; i < N+1; i++) {
                if (distArr[now.to][i] == 0) continue;
                if (minimumDist[i] > minimumDist[now.to] + distArr[now.to][i]) {
                    minimumDist[i] = minimumDist[now.to] + distArr[now.to][i];
                    boolean[] temp = new boolean[2];
                    if (i == must1) temp[0] = true;
                    else if (i == must2) temp[1] = true;
                    pq.offer(new Sejun(now.to, i, minimumDist[i], temp));
                }
            }
        }
    }

}
