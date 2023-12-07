package SSAFY.study.algo.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_실버2_15663_N과M9 {

    static int N, M;
    static int[] numbers;
    static Set<int[]> permSet;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        permutation(new boolean[N], 0, new int[M]);
        Iterator<int[]> it = permSet.iterator();
        while (it.hasNext()) {
            int[] permArr = it.next();
            for (int i = 0; i < permArr.length; i++) {
                sb.append(permArr[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        permSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);   // 오름차순 정렬
    }

    static void permutation(boolean[] visited, int cnt, int[] selected) { // 순열 구하기

        if (cnt == M) { // M개만큼 숫자 골랐으면 종료
            int[] inputArr = new int[M];
            for (int i = 0; i < M; i++) {
                inputArr[i] = selected[i];
            }
            permSet.add(inputArr);

            return;
        }

        for (int i  = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            selected[cnt] = numbers[i];
            permutation(visited, cnt+1, selected);
            visited[i] = false;
//            selected[cnt] = 0;
        }
    }

}
