package BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_실버2_2644_촌수계산_dfs {

    static class Edge { // 부모 자식 관계를 나타내는 간선
        int parent;
        int child;

        public Edge(int parent, int child) {
            this.parent = parent;
            this.child = child;
        }
    }

    static int n, m;
    static int a, b;    // 촌수를 계산해야 하는 두 사람의 번호
    static List<List<Edge>> edgeList;
    static int minCount;    // 가장 낮은 촌수를 리턴

    public static void main(String[] args) throws IOException {
        init();
        boolean[] isVisited = new boolean[n+1];
        isVisited[a] = true;
        dfs(a, 0, isVisited);
        if (minCount == 101) System.out.println(-1);
        else System.out.println(minCount);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        edgeList = new ArrayList<>();
        for (int i = 0; i < n+1; i++) edgeList.add(new ArrayList<>());
        int parent, child;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            parent = Integer.parseInt(st.nextToken());
            child = Integer.parseInt(st.nextToken());
            edgeList.get(parent).add(new Edge(parent, child));
            edgeList.get(child).add(new Edge(child, parent));
        }
        minCount = 101;
    }

    static void dfs(int now, int count, boolean[] isVisited) {
        if (now == b) {
            minCount = Math.min(minCount, count); // 촌수 계산 끝난 경우
            return;
        }

        List<Edge> nextFamilyList = edgeList.get(now);
        Edge nextFamily;
        int child;
        for (int i = 0; i < nextFamilyList.size(); i++) {
            nextFamily = nextFamilyList.get(i);
            child = nextFamily.child;
            if (isVisited[child]) continue;
            isVisited[child] = true;
            dfs(child, count+1, isVisited);
            isVisited[child] = false;
        }
    }

}
