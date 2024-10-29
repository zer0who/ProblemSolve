package SSAFY.study.algo.week50s.week59;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_20208_진우의민트초코우유 {

    static class Jinu {
        int row;
        int col;
        int hp;

        public Jinu(int row, int col, int hp) {
            this.row = row;
            this.col = col;
            this.hp = hp;
        }
    }

    static int N, M, H;
    static int[] house; // 집 좌표
    static List<int[]> milks;   // 초코 우유 좌표가 들어 있는 리스트

    public static void main(String[] args) throws IOException {
        init();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        milks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int info;
            for (int j = 0; j < N; j++) {
                info = Integer.parseInt(st.nextToken());
                if (info == 2) milks.add(new int[] {i, j});
                else if (info == 1) house = new int[] {i, j};
            }
        }
    }

}
