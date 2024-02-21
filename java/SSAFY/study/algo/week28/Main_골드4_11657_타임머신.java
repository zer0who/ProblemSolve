package SSAFY.study.algo.week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    }

}
