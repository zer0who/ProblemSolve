package SSAFY.study.algo.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_골드3_17779_게리맨더링2 {

    static int N;
    static int[][] populations; // 처음에 구역 별 인구 수
    static int[][] section; // 몇 번 선거구인지 저장하는 배열
    static int minDiff; // 최소 인구 수를 저장하는 함수

    public static void main(String[] args) throws IOException {
        init();
        doSection();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        populations = new int[N+1][N+1];    // 문제에서 1행 1열부터 카운트해서, 헷갈리지 않게 크기 지정
        section = new int[N+1][N+1];
        StringTokenizer st;
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                populations[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void setSection(int r, int c, int d1, int d2) {  // 나눈 구역을 표시하며 최소, 최대 인구 수를 저장하는 함수
        // section1: 1 ≤ r < x+d1, 1 ≤ c ≤ y
        // section2: 1 ≤ r ≤ x+d2, y < c ≤ N
        // section3: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
        // section4: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
        // section5: N*N에서 1, 2, 3, 4 뺀 값
        int minPop = Integer.MAX_VALUE; // 최대 인구 수
        int maxPop = Integer.MIN_VALUE; // 최소 인구 수


        section = new int[N+1][N+1];
    }

    static void doSection() { // r, c, d1, d2를 정해 구역 나눠보는 함수
        // d1: 왼쪽 아래 방향으로의 길이, d2: 오른쪽 아래 방향으로의 길이
        for (int r = 1; r < N+1; r++) {
            for (int c = 1; c < N+1; c++) {
                int d1 = 1;
                int d2 = 1;
                while (true) {  // d1에 대한 while문
                    if (r + d1 + d2 > N) break;    // 조건1 : 1 ≤ r < r+d1+d2 ≤ N
                    while (true) {  // d2에 대한 while문
                        if (c - d1 < 1 || c + d2 > N) break;   // 조건2 : 1 ≤ c-d1 < c < c+d2 ≤ N
                        // 여기서 나눈 선거구에서 최소, 최대 인구 수 구하기
                        setSection(r, c, d1, d2);
                        d2 += 1;
                    }
                    d1 += 1;
                }
            }
        }
    }

}
