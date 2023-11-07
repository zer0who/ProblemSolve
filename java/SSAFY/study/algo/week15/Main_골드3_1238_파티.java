package SSAFY.study.algo.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_골드3_1238_파티 {

    static class Road implements Comparable<Road> {
        int to;
        int weight;

        public Road(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Road o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return this.to + " " + this.weight;
        }
    }
    static List<ArrayList<Road>> adjRoad;    // 연결된 도로 나타낼 리스트
    static int N, M, X;

    public static void main(String[] args) throws IOException {
        init();
        int answer = Integer.MIN_VALUE;
        for (int n = 1; n <= N; n++) {    // 1번부터 N번 학생까지 반복
            int goDist = dijkstra(n, X);
            int backDist = dijkstra(X, n);
//            System.out.println(goDist + backDist);
            answer = Math.max(answer, goDist+backDist);
//            System.out.println(answer);
//            System.out.println("==========");
        }
        System.out.println(answer);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adjRoad = new ArrayList<ArrayList<Road>>();

        for (int i = 0; i < M+1; i++) {
            adjRoad.add(new ArrayList<Road>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjRoad.get(from).add(new Road(to, weight));
        }
    }

    static int dijkstra(int from, int to) {
        int[] dist = new int[M+1];
        for (int i = 0; i < M+1; i++) dist[i] = Integer.MAX_VALUE;
        dist[from] = 0; // 출발한 마을 거리는 0
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.offer(new Road(from, 0));

        while (!pq.isEmpty()) {
            Road nowRoad = pq.poll();
            int nowTo = nowRoad.to;

            for (int i = 0; i < adjRoad.get(nowTo).size(); i++) {    // 향하고 있는 도로에 대해서
                Road toRoad = adjRoad.get(nowTo).get(i);    // 연결된 도로 하나 뽑음
                if (dist[toRoad.to] > dist[nowTo] + toRoad.weight) {
                    dist[toRoad.to] = dist[nowTo] + toRoad.weight;
                    pq.offer(new Road(toRoad.to, dist[toRoad.to]));
                }
            }
        }
//        System.out.println("from : " + from + ", to : " + to);
//        System.out.println(Arrays.toString(dist));

        return dist[to];
    }

}
