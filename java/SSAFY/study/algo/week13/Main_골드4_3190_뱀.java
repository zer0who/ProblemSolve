package SSAFY.study.algo.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드4_3190_뱀 {

    static class Snake {
        int[] head;
        int[] tail;
        int dir;

        public Snake(int[] head, int[] tail, int dir) {
            this.head = head;
            this.tail = tail;
            this.dir = dir;
        }

        @Override
        public String toString() { return Arrays.toString(this.head) + " " + Arrays.toString(this.tail) + " " + this.dir; }
    }

    static Map<String, Integer> dirMap = new HashMap<>() {{    // 상 하 좌 우
        put("U", 0);
        put("D", 1);
        put("L", 2);
        put("R", 3);
    }};
    static int[] dirRow = {-1, 1, 0, 0};
    static int[] dirCol = {0, 0, -1, 1};
    static int answer;  // 경과한 시간
    static int N, K, L;
    static List<int[]> apples;  // 사과들의 좌표
    static List<String[]> turns;    // 뱀 방향전환 정보([0: 몇 초때인지, 1: 전환할 방향])
    static boolean[][] snakeBody;   // 뱀의 현재 모양을 저장할 배열

    public static void main(String[] args) throws IOException {
        init();
        Snake initialSnake = new Snake(new int[] {0, 0}, new int[] {0, 0}, dirMap.get("R"));
        playDummy(initialSnake, 0);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        apples = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            apples.add(new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1});
        }
        L = Integer.parseInt(br.readLine());
        turns = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            turns.add(new String[] {st.nextToken(), st.nextToken()});
        }
    }

    static boolean isDied(int row, int col) {   // 벽이나 자기 자신의 몸과 부딪히면 게임 종료
        if ((row == 0 || row == N) || (col == 0 || col == N) || snakeBody[row][col]) return true;  // 이동한 곳이 벽이거나 자기 몸이면 종료

        return false;
    }

    static void playDummy(Snake snake, int time) {  // time: 경과한 시간
        int[] movedHead = {snake.head[0] + dirRow[snake.dir], snake.head[1] + dirCol[snake.dir]};
        if (isDied(movedHead[0], movedHead[1])) { // 종료조건
            answer = time;
            return;
        }

        if (apples.contains(movedHead)) {   // 이동한 칸이 사과라면

            apples.remove(movedHead);
        } else {    // 사과가 아니라면 꼬리 이동

        }

        if (turns.size() != 0 && time == Integer.parseInt(turns.get(0)[0])) {    // 방향 바꿔줄 시간이면 방향 바꿔줌
            snake.dir = dirMap.get(turns.get(0)[1]);    // 방향 바꿔줌
            turns.remove(0);
        }
        playDummy(snake, time+1);
    }

}
