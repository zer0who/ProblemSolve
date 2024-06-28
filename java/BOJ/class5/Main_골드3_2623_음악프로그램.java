package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드3_2623_음악프로그램 {

    static class Edge {
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() { return this.from + " " + this.to; }
    }

    static int N, M;
    static List<List<Edge>> edgeList;
    static int[] inComes;   // 진입 차수 관리용 배열


    public static void main(String[] args) throws IOException {
        init();
        calcTurn();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edgeList = new ArrayList<>();
        for (int i = 0; i < N+1; i++) edgeList.add(new ArrayList<>());
        inComes = new int[N+1];
        int numRule, from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            numRule = Integer.parseInt(st.nextToken());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            edgeList.get(from).add(new Edge(from, to));
            inComes[to]++;
            while (st.hasMoreTokens()) {
                from = to;
                to = Integer.parseInt(st.nextToken());
                edgeList.get(from).add(new Edge(from, to));
                inComes[to]++;
            }
        }
    }

    static void calcTurn() {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < inComes.length; i++) if (inComes[i] == 0) queue.offer(i);

        int now, nowTo;
        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            now = queue.poll();
            answer.add(now);
            List<Edge> nowEdgeList = edgeList.get(now);
            for (int i = 0; i < nowEdgeList.size(); i++) {
                Edge nowEdge = nowEdgeList.get(i);
                nowTo = nowEdge.to;
                if (--inComes[nowTo] == 0) queue.offer(nowTo);
            }
        }
        if (answer.size() == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answer.size(); i++) sb.append(answer.get(i)).append("\n");
            System.out.println(sb);
        } else System.out.println(0);
    }

}
