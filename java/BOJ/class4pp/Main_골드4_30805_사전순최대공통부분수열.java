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
    static int maxValueIndexA, maxValueIndexB;  // 우선 두 배열 모두 가진 값 중 가장 큰 값의 인덱스를 저장

    public static void main(String[] args) throws IOException {
        init();
        if (maxValueIndexA == -1) System.out.println(0);    // 공통으로 가진 수가 하나도 없으면 K = 0임
        else {
            findMaxCommonSubsequences();
        }
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

        int tempMax = 0;
        maxValueIndexA = -1;
        maxValueIndexB = -1;
        for (int i = 0; i < N; i++) {
            if (tempMax >= A[i]) continue;
            for (int j = 0; j < M; j++) {
                if (B[j] == A[i]) {
                    maxValueIndexA = i;
                    maxValueIndexB = j;
                    tempMax = A[i];
                    break;
                }
            }
        }
    }

    static void findMaxCommonSubsequences() {
        List<Integer> answer = new ArrayList<>();
        answer.add(A[maxValueIndexA]);
        int tempMax, startIndexA, startIndexB;
        while (true) {
            tempMax = 0;
            startIndexA = maxValueIndexA;
            startIndexB = maxValueIndexB;
            for (int i = startIndexA+1; i < N; i++) {
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
