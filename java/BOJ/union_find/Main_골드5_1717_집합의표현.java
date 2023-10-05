package BOJ.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_골드5_1717_집합의표현 {

    static int n, m;
    static int[] set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        initSet();
        unionFind(br, st);
    }

    private static void initSet() {
        set = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            set[i] = i;
        }
    }

    static int find(int num) {
        if (num == set[num]) return num;

        return set[num] = find(set[num]);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        set[bRoot] = aRoot;
    }

    static void unionFind(BufferedReader br, StringTokenizer st) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int mode = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (mode == 0) {	// 합집합
                union(a, b);
            } else if (mode == 1) {	// 같은 집합인지 확인
                if (find(a) == find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

}
