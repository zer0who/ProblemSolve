package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_골드5_15681_트리와쿼리 {

    static class Edge {
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static int N, R, Q;
    static List<List<Edge>> edgeList;
    static int[] queries;
    static int[] nodeCounts;
    static boolean[] isChecked;


    public static void main(String[] args) throws IOException {
        init();
        countNodes(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            sb.append(nodeCounts[queries[i]]).append("\n");
        }
        System.out.println(sb);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        edgeList = new ArrayList<>();
        for (int i = 0; i < N+1; i++) edgeList.add(new ArrayList<>());
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgeList.get(from).add(new Edge(from, to)); // 무향 트리이므로 양쪽 모두에 넣어줌
            edgeList.get(to).add(new Edge(to, from));
        }
        queries = new int[Q];
        for (int i = 0; i < Q; i++) queries[i] = Integer.parseInt(br.readLine());
        nodeCounts = new int[N+1];
        isChecked = new boolean[N+1];
    }

    static void countNodes(int nodeNumber) {  // 각 서브트리에 속한 노드의 개수를 카운트하기 위한 함수, 루트부터 시작하여 재귀적으로 동작하게.
        nodeCounts[nodeNumber] = 1; // 자신도 트리의 정점 중 하나이므로 1부터 시작
        isChecked[nodeNumber] = true;
        List<Edge> nowChilds = edgeList.get(nodeNumber);
        for (int i = 0; i < nowChilds.size(); i++) {
            Edge nowChildEdge = nowChilds.get(i);
            int child = nowChildEdge.to;
            if (isChecked[child]) continue;
            countNodes(child);
            nodeCounts[nodeNumber] += nodeCounts[child];
        }
    }

}
