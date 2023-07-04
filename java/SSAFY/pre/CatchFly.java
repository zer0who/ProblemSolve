package SSAFY.pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CatchFly {
    static final int[] plus_shape_x = {-1, 0, 1, 0}; // 시계 방향
    static final int[] plus_shape_y = {0, -1, 0, 1};
    static final int[] cross_shape_x = {-1, 1, 1, -1};
    static final int[] cross_shape_y = {-1, -1, 1, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 0;
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] flies = fliesMap(br, st, N);    // 파리 수 2차원 배열
            int caught_flies = catchFlies(answer, N, M, flies);
            System.out.println("#" + tc + " " + caught_flies);
        }
    }

    private static int[][] fliesMap(BufferedReader br, StringTokenizer st, int N) throws IOException {
        int[][] flies = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                flies[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return flies;
    }

    private static int catchFlies(int answer, int N, int M, int[][] flies) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count_plus = flies[i][j];   // 맨 처음 파리 수는 중앙의 수
                int count_cross = flies[i][j];
                for (int k = 0; k < 4; k++) {   // 시계 방향으로 한 번씩
                    for (int l = 1; l < M; l++) {   // 분사 범위만큼(1부터 중앙포함 M만큼)
                        int plus_x = i + plus_shape_x[k]*l;
                        int plus_y = j + plus_shape_y[k]*l;
                        int cross_x = i + cross_shape_x[k]*l;
                        int cross_y = j + cross_shape_y[k]*l;

                        if ((0 <= plus_x && plus_x <= N-1) && (0 <= plus_y && plus_y <= N-1)) { // 범위 안이면 더해줌
                            count_plus += flies[plus_x][plus_y];
                        }
                        if ((0 <= cross_x && cross_x <= N-1) && (0 <= cross_y && cross_y <= N-1)) {
                            count_cross += flies[cross_x][cross_y];
                        }
                        int caught_flies = Math.max(count_plus, count_cross);   // 더 많이 잡은 값
                        if (caught_flies > answer) {
                            answer = caught_flies;
                        }
                    }
                }
            }
        }

        return answer;
    }

}
