package BOJ.class4pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_골드4_30805_사전순최대공통부분수열 {

    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        init();
        findMaxCommonSubsequences();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
    }

    static void findMaxCommonSubsequences() {
        List<Integer> answer = new ArrayList<>();
        int maxValueIndexA = -1;    // 두 배열 모두 가진 값 중 가장 큰 값의 인덱스를 저장
        int maxValueIndexB = -1;

        int tempMax, startIndexA, startIndexB;
        while (true) {
            tempMax = 0;
            startIndexA = maxValueIndexA;
            startIndexB = maxValueIndexB;
            for (int i = startIndexA+1; i < N; i++) {   // 이때까지 찾은 가장 큰 값의 인덱스 다음 수부터 탐색 시작
                if (tempMax >= A[i]) continue;
                for (int j = startIndexB+1; j < M; j++) {
                    if (B[j] == A[i]) {
                        maxValueIndexA = i;
                        maxValueIndexB = j;
                        tempMax = A[i];
                        break;
                    }
                }
            }
            if (tempMax == 0) break; // 더 이상 공통으로 포함한 숫자가 없는 경우 -> 중단
            answer.add(tempMax);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (int i = 0; i < answer.size(); i++) sb.append(answer.get(i)).append(" ");
        System.out.println(sb);
    }

}
