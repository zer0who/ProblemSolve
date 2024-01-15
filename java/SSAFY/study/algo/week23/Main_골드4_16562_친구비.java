package SSAFY.study.algo.week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_골드4_16562_친구비 {

    static class Edge {
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static int N, M, k;
    static int[] fees;  // 친구비(크기 N+1로 만들기)
    static List<List<Edge>> network;

    public static void main(String[] args) {

    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        fees = new int[N+1];    // 친구 관계가 1부터 주어져서 N+1로
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N+1; i++) fees[i] = Integer.parseInt(st.nextToken());
        network = new ArrayList<>();
        for (int i = 0; i < N+1; i++) network.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            network.get(from).add(new Edge(from, to));
            network.get(to).add(new Edge(to, from));
        }
    }

}
