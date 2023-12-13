package BOJ.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_실버2_11725_트리의부모찾기 {

    static int N;
    static int[] parent;
    static List<List<Integer>> tree;

    public static void main(String[] args) throws IOException {
        init();
        boolean[] isVisited = new boolean[N+1];
        for (int i = 1; i < N+1; i++) {
            int nowNode = i;
            if (isVisited[nowNode]) continue;
            isVisited = findParent(nowNode, isVisited, parent[nowNode]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N+1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        tree = new ArrayList<>();   // 트리 초기화
        for (int i = 0; i < N+1; i++) {
            tree.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
    }


    static boolean[] findParent(int nowNode, boolean[] isVisited, int beforeNode) {
        if (isVisited[nowNode]) return isVisited;

        isVisited[nowNode] = true;
        parent[nowNode] = beforeNode;

        for (int i = 0; i < tree.get(nowNode).size(); i++) {
            findParent(tree.get(nowNode).get(i), isVisited, nowNode);
        }

        return isVisited;
    }

}
