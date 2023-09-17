package BOJ.class3p;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_실버3_2606_바이러스 {

    private static int virus;
    private static int N;   // 컴퓨터 수
    private static int L;   // 연결된 컴퓨터 쌍 수
    private static int[][] computerLinks;    // 컴퓨터가 연결된 것을 나타낼 인접행렬
    private static int[] infected;  // 컴퓨터 감염 여부 체크

    public static void main(String[] args) throws Exception {
        init();
        calcVirus();
        System.out.println(virus);
    }

    public static void init() throws Exception{
        virus = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        L = Integer.parseInt(br.readLine());

        computerLinks = new int[N][N];
        infected = new int[N];
        infected[0] = 1;    // 1은 감염된 채로 시작
        StringTokenizer st;
        for (int i = 0; i < L; i++) {   // 연결 정보 저장
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            computerLinks[a][b] = 1;
            computerLinks[b][a] = 1;
        }
    }

    public static void calcVirus() {    // bfs
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int computerIdx = queue.poll();
            if (computerIdx != 0) virus += 1;
            for (int i = 0; i < N; i++) {
                if (computerLinks[computerIdx][i] == 1 && infected[i] == 0) {
                    queue.offer(i); // 큐에 삽입
                    infected[i] = 1;
                }
            }
        }
    }

}
