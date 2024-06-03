package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드4_1197_최소스패닝트리 {

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    static int V, E;
    static PriorityQueue<Edge> pq;  // 크루스칼 알고리즘을 위한 pq
    static int[] parent;    // 부모 노드 저장용 배열

    public static void main(String[] args) throws IOException {
        init();
        kruskal();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        parent = new int[V+1];
        for (int i = 0; i < V+1; i++) parent[i] = i;    // 우선 각 노드의 부모는 자기 자신으로 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(from, to, cost));
        }
    }


    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {    // 싸이클 여부를 판단해야 하므로 boolean 리턴
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) return false;   // 싸이클인 경우를 거짓으로 리턴

        if (parentA < parentB) parent[parentB] = parentA;   // 싸이클 아닌 경우 부모 갱신, 부모 노드 번호가 작은 곳으로 합침
        else parent[parentA] = parentB;

        return true;
    }

    static void kruskal() { // 음의 가중치도 가지므로 크루스칼 알고리즘 활용(프림도 가능)
        int totalCost = 0;
        int edgeCount = 0;  // 스패닝 트리의 조건으로, 간선의 개수는 최대 V-1개임.
        while (!pq.isEmpty() && edgeCount < V-1) {   // 모든 간선에 대해서 확인
            Edge now = pq.poll();
            if (!union(now.from, now.to)) continue; // 싸이클이라면 트리에 연결하지 않음.
            totalCost += now.cost;    // 싸이클이 아니라면 최소 신장 트리에 적합한 간선이므로 가중치 카운트
            edgeCount++;
        }
        System.out.println(totalCost);
    }

}
