package BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_실버1_5014_스타트링크 {

    static int F, S, G;   // F: 총 층 수, S: 맨처음 강호의 층, G: 목표 층
    static int[] dir;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        dir = new int[] {Integer.parseInt(st.nextToken()), -Integer.parseInt(st.nextToken())};  // 위(0), 아래(1) 방향으로 움직이는 양 저장
    }

    static void bfs() {
        int minCount = 10_000_000;
        boolean[] isVisited = new boolean[1_000_001];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {S, 0});
        isVisited[S] = true;

        int[] now;
        int next;
        while (!q.isEmpty()) {
            now = q.poll();
            if (now[0] == G) {
                minCount = Math.min(minCount, now[1]);
                continue;
            }

            for (int d = 0; d < 2; d++) {
                next = now[0] + dir[d];
                if (isOuted(next) || isVisited[next]) continue;
                isVisited[next] = true;
                q.offer(new int[] {next, now[1]+1});
            }
        }
        if (minCount == 10_000_000) System.out.println("use the stairs");
        else System.out.println(minCount);
    }

    static boolean isOuted(int floor) {
        if (0 < floor && floor <= F) return false;
        return true;
    }

}
