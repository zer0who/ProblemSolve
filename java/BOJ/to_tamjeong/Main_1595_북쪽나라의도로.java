package BOJ.to_tamjeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1595_북쪽나라의도로 {

    static class Road {
        int from;
        int to;
        int dist;

        public Road(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
    static int cityCount;
    static List<List<Road>> roadList;
    static int[] farCityInfo; // 1번 도시로부터 가장 거리가 먼 도시 번호와 거리 저장


    public static void main(String[] args) throws IOException {
        init();
        if (cityCount != 0) {
            boolean[] isVisited = new boolean[10_001];
            isVisited[1] = true;
            calcDist(1, 0, isVisited);  // 1번 도시에서 가장 거리가 먼 도시와 그 거리 찾기

            isVisited = new boolean[10_001];
            isVisited[farCityInfo[0]] = true;
            calcDist(farCityInfo[0], 0, isVisited);

            System.out.println(farCityInfo[1]);
        } else System.out.println(0);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cityCount = 0;
        roadList = new ArrayList<>();
        for (int i = 0; i < 10_001; i++) roadList.add(new ArrayList<>());
        StringTokenizer st;
        int from, to, dist;
        while (true) {
            try {
                st = new StringTokenizer(br.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                dist = Integer.parseInt(st.nextToken());
                roadList.get(from).add(new Road(from, to, dist));
                roadList.get(to).add(new Road(to, from, dist));
                cityCount += 1;
            } catch (Exception e) {
                break;
            }
        }
        farCityInfo = new int[2];
    }

    static void calcDist(int now, int totalDist, boolean[] isVisited) {
        List<Road> nextRoadList = roadList.get(now);
        Road nextRoad;
        for (int i = 0; i < nextRoadList.size(); i++) {
            nextRoad = nextRoadList.get(i);
            if (isVisited[nextRoad.to]) continue;
            if (totalDist + nextRoad.dist > farCityInfo[1]) {
                farCityInfo[0] = nextRoad.to;
                farCityInfo[1] = totalDist + nextRoad.dist;
            }
            isVisited[nextRoad.to] = true;
            calcDist(nextRoad.to, totalDist+nextRoad.dist, isVisited);
        }
    }

}
