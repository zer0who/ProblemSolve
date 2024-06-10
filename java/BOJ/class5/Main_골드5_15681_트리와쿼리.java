package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_골드5_15681_트리와쿼리 {

    static int N, R, Q;
    static List<List<Integer>> edgeList;
    static int[] queries;
    static int[] nodeCounts;
    static boolean[] isChecked;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        countNodes(R);
        for (int i = 0; i < Q; i++) {
            sb.append(nodeCounts[queries[i]]).append('\n');
        }
        System.out.print(sb);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        edgeList = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) edgeList.add(new ArrayList<>());
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgeList.get(from).add(to);
            edgeList.get(to).add(from);
        }
        queries = new int[Q];
        for (int i = 0; i < Q; i++) queries[i] = Integer.parseInt(br.readLine());
        nodeCounts = new int[N + 1];
        isChecked = new boolean[N + 1];
    }

    static void countNodes(int nodeNumber) {
        nodeCounts[nodeNumber] = 1; // 자신도 트리의 정점 중 하나이므로 1부터 시작
        isChecked[nodeNumber] = true;
        for (int child : edgeList.get(nodeNumber)) {
            if (!isChecked[child]) {
                countNodes(child);
                nodeCounts[nodeNumber] += nodeCounts[child];
            }
        }
    }

}
