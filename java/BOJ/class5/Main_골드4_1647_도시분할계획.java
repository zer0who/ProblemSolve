package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_골드4_1647_도시분할계획 {

    static class Road implements Comparable<Road> {
        int from;
        int to;
        int cost;

        public Road(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road r) {
            return this.cost - r.cost;
        }
    }

    static int N, M;
    static int[] parent;    // 부모를 저장할 배열
    static PriorityQueue<Road> pq;  // 처음 입력받는 Road들을 정렬할 때 사용할 priority queue

    public static void main(String[] args) throws IOException {
        init();
        kruskal();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i =0; i < N+1; i++) parent[i] = i; // 우선 각 노드의 부모를 자기 자신으로 초기화
        pq = new PriorityQueue<>();
        int from, to, cost;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            pq.offer(new Road(from, to, cost));
        }
    }

    static int find(int a) {
        if (parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) return false;

        if (parentA < parentB) parent[parentB] = parentA;
        else parent[parentA] = parentB;

        return true;
    }

    static void kruskal() { // 풀이 전략: 최소 스패닝 트리 생성 후 총 비용에서 가장 큰 비용만큼만 빼줌.
        int totalCost = 0;
        int edgeCount = 0;  // 트리에 포함된 간선 개수
        int maxCost = 0;    // 연결된 간선 비용 중 가장 큰 비용
        while (!pq.isEmpty() && edgeCount < N-1) {  // 스패닝 트리의 최대 간선 개수는 노드 개수-1임.
            Road now = pq.poll();
            if (!union(now.from, now.to)) continue;  // 싸이클 형성하면 넘어감
            totalCost += now.cost;
            edgeCount += 1; // 싸이클 형성 안하면
            maxCost = Math.max(maxCost, now.cost);
        }
        System.out.println(totalCost - maxCost);
    }

}
