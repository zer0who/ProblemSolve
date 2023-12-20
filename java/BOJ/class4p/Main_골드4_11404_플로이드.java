package BOJ.class4p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드4_11404_플로이드 {

    static class Bus implements Comparable<Bus> {
        int from;
        int to; // from 개념은 List의 인덱스로 처리
        int cost;   // to까지 가는 데 드는 비용

        public Bus(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Bus{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(Bus o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int n, m;
    static List<List<Bus>> busList;
    static int[][] cost;    // from 에서 to로 가는데 드는 최소 비용 저장할 배열

    public static void main(String[] args) throws IOException {
        init();
//        System.out.println(busList);
        for (int i = 1; i < n+1; i++) {
            dijkstra(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (cost[i][j] == Integer.MAX_VALUE) sb.append(0).append(" ");  // 갈 수 없는 경우 0으로 출력
                else sb.append(cost[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        busList = new ArrayList<>();
        for (int i = 0; i < n+1; i++) busList.add(new ArrayList<>());

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            busList.get(from).add(new Bus(from, to, cost));
        }
        cost = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i != j) cost[i][j] = Integer.MAX_VALUE; // 자기 자신으로 가는 경우는 0으로 놔둠
            }
        }
    }

    static void dijkstra(int start) {
        List<Bus> initBuses = busList.get(start);
        PriorityQueue<Bus> queue = new PriorityQueue<>();
        for (int i = 0; i < initBuses.size(); i++) {    // 출발지에서의 비용 갱신
            Bus initBus = initBuses.get(i);
            if (cost[initBus.from][initBus.to] > initBus.cost) cost[initBus.from][initBus.to] = initBus.cost;   // 같은 행선지인 버스가 있으므로, 작은 값이 저장되게
            queue.offer(initBus);   // 맨 처음 큐에는 출발 도시의 버스를 다 넣어줌.
        }

        while (!queue.isEmpty()) {
            Bus now = queue.poll();
            int nowFrom = now.from;
            int nowTo = now.to;
            int nowCost = now.cost;

            if (cost[nowFrom][nowTo] < nowCost) continue;

            List<Bus> nextBuses = busList.get(nowTo);
            for (int i = 0; i < nextBuses.size(); i++) {
                Bus next = nextBuses.get(i);
                int nextTo = next.to;
                int nextCost = next.cost;

                if (cost[start][nextTo] > cost[start][nowTo] + nextCost) {
                    cost[start][nextTo] = cost[start][nowTo] + nextCost;
                    queue.offer(next);
                }
            }

//            for (int i = 0; i < n+1; i++) {
//                System.out.println(Arrays.toString(cost[i]));
//            }
        }
    }

}
