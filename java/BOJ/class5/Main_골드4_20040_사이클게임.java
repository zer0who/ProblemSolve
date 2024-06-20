package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_골드4_20040_사이클게임 {

    static int n, m;
    static int[] parents;   // 각 점의 부모 노드


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        doCycleGame(br);
    }

    static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i; // 부모를 자기 자신으로 초기화
    }

    static void doCycleGame(BufferedReader br) throws IOException {
        int answer = 0;
        StringTokenizer st;
        int from, to;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            if (find(from) == find(to)) {   // 각 점의 부모가 같은 경우면 싸이클이 있는 경우임
                answer = i+1;   // 그때만 정답 값 변경 후 반복문 종료
                break;
            }
            union(from, to);
        }
        System.out.println(answer);
    }

    static int find(int a) {
        if (parents[a] == a) return a;

        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) return false;   // 유니온 할 필요가 없다는 뜻에서 false 반환

        if (parentA < parentB) parents[parentB] = parentA;  // 규칙성을 가지게 하기 위해 수가 더 작은 쪽으로 합침
        else parents[parentA] = parentB;
        return true;    // 유니온을 실행했다는 뜻에서 true 반환
    }

}
