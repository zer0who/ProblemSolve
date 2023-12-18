package BOJ.class3pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main_골드5_16928_뱀과사다리게임 {

    static class Player {
        int position;   // 현재 위치한 칸
        int count;  // 움직인 횟수

        public Player(int position, int count) {
            this.position = position;
            this.count = count;
        }
    }

    static int N, M;
    static Map<Integer, Integer> ladder;
    static Map<Integer, Integer> snake;
    static boolean[][] isVisited;   // 해당 번호에서 굴린 주사위가 이미 굴렸던 경우인지 체크할 배열
    static int minCount;

    public static void main(String[] args) throws IOException {
        Player initPlayer = init();
        bfs(initPlayer);
        System.out.println(minCount);
    }

    static Player init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ladder = new HashMap<>();
        snake = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            ladder.put(from, to);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            snake.put(from, to);
        }
        isVisited = new boolean[100][7];    //  1~99번 칸에 대해서 1~6번 주사위를 굴렸는지 체크
        minCount = Integer.MAX_VALUE;
        Player initPlayer = new Player(1, 0);

        return initPlayer;
    }

    static int doMove(int position) {  // 이동한 위치가 뱀 or 사다리이면
        if (ladder.containsKey(position)) return ladder.get(position);
        else if (snake.containsKey(position)) return snake.get(position);

        return position;    // 사다리, 뱀 둘 다 안밟았다면 원래 값 반환
    }

    static void bfs(Player initPlayer) {
        Queue<Player> queue = new ArrayDeque<>();
        queue.offer(initPlayer);

        while (!queue.isEmpty()) {
            Player now = queue.poll();
            if (now.position >= 100) {  // 도착했으면 최소 횟수 갱신
                minCount = Math.min(minCount, now.count);

                continue;
            }

            for (int i = 1; i <= 6; i++) {
                if (!isVisited[now.position][i]) {  // 그 자리에서 이동하지 않았던 칸수면 이동함
                    isVisited[now.position][i] = true;
                    int moved = doMove(now.position + i);
                    queue.offer(new Player(moved, now.count + 1));
                }
            }
        }
    }

}
