package BOJ.class4p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_골드5_13549_숨바꼭질3 {

    static class Subin {
        int axis;
        int cost;

        public Subin(int axis, int cost) {
            this.axis = axis;
            this.cost = cost;
        }
    }

    static int N, K;
    static int[] costs;

    public static void main(String[] args) throws IOException {
        init();
        bfs01();
        System.out.println(costs[K]);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        costs = new int[100001];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = Integer.MAX_VALUE;
        }
    }

    static void bfs01() {
        Subin initSubin = new Subin(N, 0);
        Deque<Subin> deque = new ArrayDeque<>();
        deque.offer(initSubin);
        costs[N] = 0;

        while (!deque.isEmpty()) {
            Subin now = deque.poll();
            int nowAxis = now.axis;
            int nowCost = now.cost;

            if (nowAxis + 1 < 100001 && costs[nowAxis+1] > nowCost + 1) {   // 0을 포함한 좌표에서 +1하는 경우
                costs[nowAxis+1] = nowCost + 1;
                deque.offerFirst(new Subin(nowAxis + 1, costs[nowAxis+1]));
            }
            if (nowAxis != 0) { // 현재 위치가 0이 아니라면, *2와 -1도 고려
                if (nowAxis * 2 < 100001 && costs[nowAxis*2] > nowCost) {
                    costs[nowAxis*2] = nowCost;
                    deque.offer(new Subin(nowAxis*2, costs[nowAxis]));
                }
                if (nowAxis -1 >= 0 && costs[nowAxis-1] > nowCost + 1) {
                    costs[nowAxis-1] = nowCost + 1;
                    deque.offerFirst(new Subin(nowAxis - 1, costs[nowAxis-1]));
                }
            }
        }
    }

}
