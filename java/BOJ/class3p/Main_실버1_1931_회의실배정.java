package BOJ.class3p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_실버1_1931_회의실배정 {

    static int N;
    static int[][] times;
    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);   // 종료 시간 같으면 시작 시간 빠른 순 정렬
                return Integer.compare(o1[1], o2[1]);   // 종료 시간 기준 정렬
            }
        });

        int answer = 0;
        int endTime = 0;
        for (int i = 0; i < N; i++) {
            if (endTime <= times[i][0]) {
                endTime = times[i][1];
                answer += 1;
            }
        }
        System.out.println(answer);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i] = new int[] {start, end};
        }

    }

}
