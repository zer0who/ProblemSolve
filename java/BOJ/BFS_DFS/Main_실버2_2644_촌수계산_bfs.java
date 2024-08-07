package BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_실버2_2644_촌수계산_bfs {

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

    public static void main(String[] args) throws IOException {
        init();
        bfs();
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
    }

    static void bfs() {
        int minCount = 101;
        boolean[] isVisited = new boolean[n+1];
        Queue<int[]> q = new ArrayDeque<>();    // 큐에 들어가는 배열의 0번 인덱스: 현재 가족 번호, 1번 인덱스: 촌수 카운트
        q.offer(new int[] {a, 0});

        int[] now;
        List<Edge> nextFamilyList;
        int child;
        while (!q.isEmpty()) {
            now = q.poll();
            if (now[0] == b) minCount = Math.min(minCount, now[1]);

            nextFamilyList = edgeList.get(now[0]);
            for (int i = 0; i < nextFamilyList.size(); i++) {
                child = nextFamilyList.get(i).child;
                if (isVisited[child]) continue;
                isVisited[child] = true;
                q.offer(new int[] {child, now[1]+1});
            }
        }

        if (minCount == 101) System.out.println(-1);
        else System.out.println(minCount);
    }

}
