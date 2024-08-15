package BOJ.to_tamjeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16918_봄버맨 {

    static int[] dirRow = new int[] {-1, 1, 0, 0};  // 상 하 좌 우
    static int[] dirCol = new int[] {0, 0, -1, 1};

    static class Bomb {
        int row;
        int col;
        int time;

        public Bomb(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    static int R, C;
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        init();
        bomberMan();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        N = Integer.parseInt(st.nextToken());

        String inputLine, inputColumn;
        for (int i = 0; i < R; i++) {
            inputLine = br.readLine();
            for (int j = 0; j < C; j++) {
                inputColumn = String.valueOf(inputLine.charAt(j));
                if (inputColumn.equals("O")) map[i][j] = 0;
                else map[i][j] = -1;    // 빈자리는 -1로 표시
            }
        }
    }

    static void bomberMan() {
        for (int i = 2; i <= N; i++) {   // N-1초간 반복
            if (i % 2 == 0) plantBomb(i);
            else if (i % 2 == 1) bomb(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
