package SSAFY.study.algo.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드2_4195_친구네트워크 {

    static int F;
    static int idx;	// 해쉬맵의 value가 될 인덱스
    static HashMap<String, Integer> friends;
    static int[] friendRoot;	// 각 친구의 대장 친구
    static int[] count;	// 친구 수 적은 쪽으로 합치기 위한 count 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            sb.append(init(br));
        }
        System.out.println(sb);
    }

    static int find(int idx) {	// 대장 친구 인덱스 찾기
        if (idx == friendRoot[idx]) return idx;

        return friendRoot[idx] = find(friendRoot[idx]);
    }

    static int union(int a, int b) {	// a 친구와 b 친구 네트워크 합치기
        int aRoot = find(a);
        int bRoot = find(b);

        friendRoot[bRoot] = aRoot;

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < idx; i++) {	// 현재 입력된 친구까지 탐색
            if (friendRoot[i] == bRoot) friendRoot[i] = aRoot;	// 합쳐진 친구의 원래 친구도 새로운 네트워크로 합침
            if (friendRoot[i] == aRoot) cnt += 1;
        }

        return cnt;
    }

    static String init(BufferedReader br) throws IOException {
        F = Integer.parseInt(br.readLine());
        idx = 0;
        friends = new HashMap<>();
        friendRoot = new int[200001];	// 관계 수 10만개(x2)까지 주어진다고 했으므로 이 값으로 초기화
        count = new int[200001];
        for (int i = 0; i < friendRoot.length; i++) {
            friendRoot[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < F; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String firstName = st.nextToken();
            String secondName = st.nextToken();
            if (!friends.containsKey(firstName)) friends.put(firstName, idx++);	// 해쉬맵에 인덱스가 저장돼있지 않으면 저장하기
            if (!friends.containsKey(secondName)) friends.put(secondName, idx++);

            sb.append(union(friends.get(firstName), friends.get(secondName))).append("\n");
        }

        return sb.toString();
    }

}
