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
        System.out.println(calcWords());
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        wordList = new ArrayList<>();
        for (int i = 0; i < N; i++) wordList.add(br.readLine());
    }

    static int calcWords() {
        if (K < 5) return 0;    // anta + tica 에서 애초에 5개의 글자를 필요로 함
        else if (K == 26) return N;   // 모든 글자를 가르칠 수 있으면 모든 단어를 읽을 수 있음

        return 0;
    }

}
