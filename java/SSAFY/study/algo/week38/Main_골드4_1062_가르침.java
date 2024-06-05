package SSAFY.study.algo.week38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_골드4_1062_가르침 {

    static int N, K;
    static List<String> wordList;   // 단어들의 리스트

    public static void main(String[] args) throws IOException {
        init();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        wordList = new ArrayList<>();
        for (int i = 0; i < N; i++) wordList.add(br.readLine());
    }

}
