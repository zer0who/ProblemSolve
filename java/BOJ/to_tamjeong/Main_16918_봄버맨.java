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

        @Override
        public boolean equals(Object o) {
            Bomb bomb = (Bomb) o;
            return row == bomb.row && col == bomb.col && time != bomb.time;
        }
    }

    static int R, C;
    static String[][] map;
    static List<Bomb> bombList;
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
        map = new String[R][C];
        bombList = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());

        String inputLine, inputColumn;
        for (int i = 0; i < R; i++) {
            inputLine = br.readLine();
            for (int j = 0; j < C; j++) {
                inputColumn = String.valueOf(inputLine.charAt(j));
                if (inputColumn.equals("O")) bombList.add(new Bomb(i, j, 0));
                map[i][j] = inputColumn;
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

    static void plantBomb(int round) {  // 비어있는 칸에 폭탄 설치
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j].equals("O")) continue;
                map[i][j] = "O";
                bombList.add(new Bomb(i, j, round));
            }
        }
    }

    static void bomb(int round) {    // 3초 전 설치한 폭탄이 터짐
        Bomb nowBomb;
        int nowRow, nowCol;
        while (bombList.size() > 0) {
            nowBomb = bombList.get(0);
            if (nowBomb.time != round - 3) break;    // 3초 전 설치한 폭탄이 아니면 중지
            nowRow = nowBomb.row;
            nowCol = nowBomb.col;
            map[nowRow][nowCol] = ".";
            int nextRow, nextCol;
            for (int d = 0; d < 4; d++) {   // 인접한 칸에 대해서도 처리
                nextRow = nowRow + dirRow[d];
                nextCol = nowCol + dirCol[d];
                if (isOuted(nextRow, nextCol)) continue;
                map[nextRow][nextCol] = ".";
                bombList.remove(new Bomb(nextRow, nextCol, nowBomb.time));  // 어차피 row, col만 같으면 삭제 처리함. 근데 이때 같은 time에 설치한 폭탄은 놔둬야 함.
            }
            bombList.remove(0);
        }
    }

    static boolean isOuted(int row, int col) {
        if ((0 <= row && row < R) && (0 <= col && col < C)) return false;
        return true;
    }

}
