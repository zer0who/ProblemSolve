package BOJ.class3pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_실버1_20529_가장가까운세사람의심리적거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            int personCnt = Integer.parseInt(br.readLine());
            int minDist = Integer.MAX_VALUE;
            String[] person = new String[personCnt];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int p = 0; p < personCnt; p++) {
                person[p] = st.nextToken();
            }

            if (personCnt < 33) {
                for (int i = 0; i < personCnt; i++) {
                    for (int j = 0; j < personCnt; j++) {
                        if (j == i) continue;
                        for (int k = 0; k < personCnt; k++) {
                            if (k == i || k == j) continue;
                            int dist = 0;
                            dist += calcDist(person[i], person[j]);
                            dist += calcDist(person[i], person[k]);
                            dist += calcDist(person[j], person[k]);
                            minDist = Math.min(minDist, dist);
                        }
                    }
                }
                System.out.println(minDist);
            } else System.out.println(0);   // 비둘기집 원리에 의해 사람이 33명 이상이면(mbti 개수가 16개이기 때문에) 3명은 무조건 mbti가 겹침.
        }
    }

    static int calcDist(String p1, String p2) {   // 사람1과 2의 심리적 거리를 계산하는 함수
        int dist = 0;
        for (int i = 0; i < 4; i++) {
            if (!String.valueOf(p1.charAt(i)).equals(String.valueOf(p2.charAt(i)))) dist += 1;
        }

        return dist;
    }

}
