package SSAFY.study.algo.week50s.week57;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main_14945_불장난 {

    static class EscapingPerson {
        int row;
        int col;

        public EscapingPerson(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N;
    static int[][] lab; // 0: 범위 밖, 1: 방, 6: 불

    public static void main(String[] args) throws IOException {
        init();
        calcEscapes();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lab = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i+1; j++) {   // 직각 삼각형 형태의 방을 표시
                lab[i][j] = 1;
            }
        }
        lab[0][0] = 6;  // 맨 윗칸은 불 입력
    }

    static void calcEscapes() {
        Queue<EscapingPerson[]> q = new ArrayDeque<>(); // 0: 기웅, 1: 민수
        q.offer(new EscapingPerson[] {new EscapingPerson(0, 0), new EscapingPerson(0, 0)});

        int[] dirRow = new int[] {1, 1};   // 우하, 하
        int[] dirCol = new int[] {1, 0};
        int answer = 0;
        EscapingPerson[] now;
        EscapingPerson gw, ms;
        while (!q.isEmpty()) {
            now = q.poll();
            gw = now[0];
            ms = now[1];

            if (gw.row == N-1 && ms.row == N-1) {
                answer++;   // 둘 다 탈출에 성공한 경우
                continue;
            }

            int nextRowGw, nextColGw, nextRowMs, nextColMs;
            for (int d1 = 0; d1 < 2; d1++) {    // 기웅이가 이동한 칸
                nextRowGw = gw.row + dirRow[d1];
                nextColGw = gw.col + dirCol[d1];
                for (int d2 = 0; d2 < 2; d2++) {    // 민수가 이동한 칸
                    nextRowMs = ms.row + dirRow[d2];
                    nextColMs = ms.col + dirCol[d2];
                    if (nextColGw != nextColMs) q.offer(new EscapingPerson[] {new EscapingPerson(nextRowGw, nextColGw), new EscapingPerson(nextRowMs, nextColMs)});
                }
            }
        }
        System.out.println(answer);
    }

}
