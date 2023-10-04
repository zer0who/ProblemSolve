package SSAFY.study.algo.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드2_4195_친구네트워크 {

    static int F;
    static HashMap<String, Integer> friends;
    static int[] firstFriend;   // 각 친구의 대장 친구

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            sb.append(init(br));
        }
        System.out.println(sb);
    }

    static int find(int a) {
        if (a == firstFriend[a]) return a;

        return firstFriend[a] = find(firstFriend[a]);
    }

    static int union(int a, int b) {    // 왼쪽 친구가 오른쪽 친구보다 대장 친구
        int aFirst = find(a);
        int bFirst = find(b);

        int cnt = 0;

        firstFriend[bFirst] = aFirst;
        for (int i = 0; i < firstFriend.length; i++) {
            if (firstFriend[i] == aFirst) cnt += 1;
        }

        return cnt;
    }

    static int calcFriendNetwork(String firstName, String secondName) {
        int count = 0;  // 리턴해줄 친구네트워크 안의 친구 수
        int idx = 0;
        if (!friends.containsKey(firstName)) {
            friends.put(firstName, idx++);
        }
        if (!friends.containsKey(secondName)) {
            friends.put(secondName, idx++);
        }
        count = union(friends.get(firstName), friends.get(secondName));

        return count;
    }

    static String init(BufferedReader br) throws IOException {
        F = Integer.parseInt(br.readLine());
        friends = new HashMap<>();
        firstFriend = new int[1000001]; // 10만개 까지 주어진다고 했으므로
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < F; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String firstName = st.nextToken();
            String secondName = st.nextToken();
            sb.append(calcFriendNetwork(firstName, secondName));
            sb.append("\n");
        }

        return sb.toString();
    }

}
