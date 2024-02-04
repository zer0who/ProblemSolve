package SSAFY.study.algo.week26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_골드4_12851_숨바꼭질2 {

    static int N, K;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        init();
        bfs();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isVisited = new boolean[100001];
    }

    static boolean isOuted(int axis) {
        if (0 <= axis && axis <= 100000) return false;
        return true;
    }

    private static Queue<Integer> doQueue(Queue<Integer> queue, int next) {
        if (isOuted(next) || isVisited[next]) return queue;
        next += 1;
        queue.offer(next);
        isVisited[next] = true;

        return queue;
    }

    static void bfs() {
        int time = 0;
        int count = 0;
        int[] dir = new int[] {-1, 1};   // 걸어가는 경우에 쓰일 벡터
        Queue<Integer> queue = new ArrayDeque<>();    // 0: 위치, 1: 이동한 횟수
        queue.offer(N);
        isVisited[N] = true;

        while (!queue.isEmpty()) {
            time += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if (now == K) { // 동생 있는 곳에 도착한 경우
                    count += 1;
                    continue;
                }

                int nextWhenTeleport = now * 2;
                queue = doQueue(queue, nextWhenTeleport);

                for (int d = 0; d < 2; d++) {
                    int nextWhenWalk = now + dir[d];
                    queue = doQueue(queue, nextWhenWalk);
                }
            }
            if (count != 0) break;  // 도착한 경우에는 반복문 바로 종료
        }

        System.out.println(time);
        System.out.println(count);
    }

}
