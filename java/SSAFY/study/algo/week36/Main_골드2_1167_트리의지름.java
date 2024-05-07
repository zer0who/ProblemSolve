package SSAFY.study.algo.week36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_골드2_1167_트리의지름 {
    
    static class Edge { // 간선 클래스
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() { return this.from + " " + this.to + " " + this.weight; }
    }
    
    static int V;   // 정점 개수
    static List<List<Edge>> edgeList;

    static int maxDist; // 임의의 한 정점에서 가장 먼 노드까지의 거리
    static int maxNode; // 그때 가장 먼 노드의 번호, 여기서 다시 가장 먼 거리 찾으면 그게 트리의 지름
    
    public static void main(String[] args) throws IOException {
        init();
        boolean[] initIsVisited = new boolean[V+1];
        initIsVisited[1] = true;
        dfs(1, initIsVisited, 1, 0);
        System.out.println(maxDist + " " + maxNode);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        edgeList = new ArrayList<>();
        for (int i = 0; i < V+1; i++) edgeList.add(new ArrayList<>());
        StringTokenizer st;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int fromNode = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int info = Integer.parseInt(st.nextToken());
                if (info == -1) break;
                int toNode = info;
                int weight = Integer.parseInt(st.nextToken());
                edgeList.get(fromNode).add(new Edge(fromNode, toNode, weight));
            }
        }
        maxDist = Integer.MIN_VALUE;
        maxNode = 0;
    }

    static void dfs(int count, boolean[] isVisited, int fromNode, int dist) {   // 탐색한 노드 개수, 출발 노드, 쌓인 거리
        if (count == V) {   // 모든 정점 다 탐색했으면 거리 더 늘어났는지 체크, 늘어났으면 갱신
            if (dist > maxDist) {
                maxDist = dist;
                maxNode = fromNode;
            }

            return;
        }
        System.out.println(count);
        for (int i = 0; i < edgeList.get(fromNode).size(); i++) {
            Edge nowEdge = edgeList.get(fromNode).get(i);
            System.out.println(nowEdge);
            int nowTo = nowEdge.to;
            if (isVisited[nowTo]) continue;
            int nowWeight = nowEdge.weight;
            isVisited[nowTo] = true;
            dfs(count + 1, isVisited, nowTo, dist + nowWeight);
            isVisited[nowTo] = false;
        }
    }

}
