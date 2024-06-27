package SSAFY.study.algo.week30s.week35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드4_2141_우체국 {

    static int N;
    static long totalPeople;
    static List<long[]> villageList;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        totalPeople = 0;
        villageList = new ArrayList<>();
        StringTokenizer st;
        long position, peopleCount;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            position = Integer.parseInt(st.nextToken());
            peopleCount = Integer.parseInt(st.nextToken());
            villageList.add(new long[] {position, peopleCount});
            totalPeople += peopleCount;
        }
        Collections.sort(villageList, new Comparator<long[]>() { // 마을의 위치 순 정렬
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0], o2[0]);
            }
        });
    }

    static void solve() {
        long mid = (totalPeople+1) / 2;
        long temp = 0;
        for (int i = 0; i < N; i++) {
            temp += villageList.get(i)[1];
            if (temp >= mid) {
                System.out.println(villageList.get(i)[0]);
                return;
            }
        }
    }

}
