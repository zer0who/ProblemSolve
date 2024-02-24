package SSAFY.study.algo.week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_골드4_11657_타임머신 {

    static class Edge {
        int from;
        int to;
        int cost;

        public Edge (int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return this.from + " " + this.to + " " + this.cost;
        }
    }

    static int N, M;
    static List<List<Edge>> edgeList;

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 2; i < N+1; i++) {
            bellmanFord(i); // 2번부터 N번 도시까지 걸리는 시간 구하기
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edgeList = new ArrayList<>();
        for (int i = 0; i < N+1; i++) edgeList.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edgeList.get(from).add(new Edge(from, to, cost));
        }
    }

    static void bellmanFord(int destination) { // 음의 사이클 존재 시 -1 출력, 경로 없을 시 -1 출력, 이외의 경우는 도착까지 걸리는 가장 짧은 시간 출력
        int[] time = new int[N + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[1] = 0;
        boolean isUpdated;
        for (int i = 0; i < N; i++) {   // 음수 사이클 존재 여부 판단을 위해 N번 순환(존재 여부 판단 안하기 위해서는 N-1번만 순환하면 됨)
            isUpdated = false;
            for (int j = 1; j < N+1; j++) {
                List<Edge> nowEdgeList = edgeList.get(j);
                for (Edge now : nowEdgeList) {
                    int nowFrom = now.from;
                    int nowTo = now.to;
                    int nowTime = now.cost;
                    if (time[nowFrom] == Integer.MAX_VALUE) continue;   // 출발지에서 현재 간선의 from인 노드로 갈 수 없으면 지나침

                    if (time[nowTo] > time[nowFrom] + nowTime) {
                        time[nowTo] = time[nowFrom] + nowTime;
                        isUpdated = true;
                    }
                }
            }

            if (!isUpdated) break;    // 더 이상 최단거리 갱신이 안되면(음수 싸이클이 존재하지 않으면) 반복문 멈춤
        }
        if (time[destination] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(time[destination]);
    }

}
