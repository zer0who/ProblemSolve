package BOJ.class2pp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_실버4_18110_solvedac {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long delNum = Math.round(N * 0.15);   // 앞, 뒤에서 자를 원소 개수
        int[] opinions = new int[N];
        long sumOpinions = 0;
        for (int i = 0; i < N; i++) {
            int inputOpinion = Integer.parseInt(br.readLine());
            opinions[i] = inputOpinion;
        }
        Arrays.sort(opinions);
        for (long i = delNum; i < N-delNum; i++) {
            sumOpinions += opinions[(int) i];
        }
        System.out.println(Math.round((float) sumOpinions / (N-2*delNum)));
    }

}
