package BOJ.to_tamjeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_12784_인하니카공화국 {

    static class Bridge {
        int from;
        int to;
        int cost;   // 폭파하는 데 필요한 다이너마이트 개수

        public Bridge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int N, M;
    static List<List<Bridge>> bridgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            init(br);
            for (int i = 0; i < bridgeList.size(); i++) {
                if (bridgeList.get(i).size() == 1) calcNeededDynamite(i);   // 다리 연결 개수 한 개인 섬에서 1까지 연결로 중 가장 다이너마이트가 적게 드는 섬 체
            }
        }

    }

    static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bridgeList = new ArrayList<>();
        for (int i = 0; i < M; i++) bridgeList.add(new ArrayList<>());

        int from, to, cost;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            bridgeList.get(from).add(new Bridge(from, to, cost));
            bridgeList.get(to).add(new Bridge(to, from, cost));
        }
    }

    static void calcNeededDynamite(int startNode) {
        // 나중에 풀기
    }

}
