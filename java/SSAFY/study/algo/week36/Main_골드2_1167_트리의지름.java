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
    
    public static void main(String[] args) throws IOException {
        init();
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
    }

}
