package SSAFY.certificateA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드4_17471_게리맨더링 {

    static int min_diff;
    static int N;
    static int[] population;    // 인구 수 저장할 배열
    static boolean[] isSelected;    // 부분집합으로 뽑은 지역구 저장용 배열
    static int[][] adj; // 선거구 인접행렬

    public static void main(String[] args) throws IOException {
        init();
        subSet(1);
        if (min_diff == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min_diff);
    }

    static void init() throws IOException {
        min_diff = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N+1];
        isSelected = new boolean[N+1];
        adj = new int[N+1][N+1];    // 도시 번호가 1부터 시작하므로
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int connected = Integer.parseInt(st.nextToken());
            for (int j = 0; j < connected; j++) {
                int adjWithI = Integer.parseInt(st.nextToken());
                adj[i][adjWithI] = 1;
                adj[adjWithI][i] = 1;
            }
        }
    }

    static int bfs(List<Integer> section) {  // bfs를 통해 해당 선거구가 연결돼있는지 판단
        int cnt = 0;
        boolean[] isVisited = new boolean[N+1];   // bfs안에서 쓰일 isVisited

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(section.get(0));
        cnt += 1;
        isVisited[section.get(0)] = true;

        while (!queue.isEmpty()) {
            int sectionNo = queue.poll();
            for (int i = 1; i < adj[sectionNo].length; i++) {   // 현재 구역과 연결된 구역 확인
                if (adj[sectionNo][i] == 1 && !isVisited[i]) {  // 연결된 구역이고, 방문하지 않은 곳이라면
                    isVisited[i] = true;
                    if (!section.contains(i))  continue; // 해당 선거구에 포함된 지역이 아니라면 pass
                    queue.offer(i);
                    cnt += 1;
                }
            }
        }

        return cnt;
    }

    static boolean isConnected() {  // 선거구 내의 지역들이 연결돼있는지 판단하는 함수
        List<Integer> trueSection = new ArrayList<>();
        List<Integer> falseSection = new ArrayList<>();
        for (int i = 1; i < N+1; i++) {   // true, false 구역 일단 나누어서 리스트에 담아줌
            if (isSelected[i]) trueSection.add(i);
            else falseSection.add(i);
        }
        if (trueSection.size() == 0 || falseSection.size() == 0) return false;  // 한 선거구에 몰려있으면 조건 불충족이므로 false 리턴

        int trueConnections = bfs(trueSection);
        int falseConnections = bfs(falseSection);
        if (trueConnections != trueSection.size() || falseConnections != falseSection.size()) return false; // bfs를 통해 탐색한 결과의 연결된 선거구 수와 기존에 뽑은 선거구의 수가 다르면 false 리턴

        return true;
    }

    static void calcPopulationDiff() { // 인구수 계산, min보다 작으면 갱신
        int truePopulation = 0;
        int falsePopulation = 0;
        for (int i = 1; i < N+1; i++) {
            if (isSelected[i]) {    // true 선거구면
                truePopulation += population[i];
            } else {    // false 선거구면
                falsePopulation += population[i];
            }
        }

        int populationDiff = Math.abs(truePopulation - falsePopulation);
        if (min_diff > populationDiff) min_diff = populationDiff;   // 더 작은 차이면 갱신
    }

    static void subSet(int cnt) {  // 부분집합으로 선거구 고름
        if (cnt == N+1) { // 구역을 두 개의 선거구로 나누었으므로, 연결돼있는지 판단 후 인구수 확인
            if (isConnected()) {    // 모든 지역구가 연결돼있으면
                calcPopulationDiff();   // 최소값 계산, 갱신
            }

            return;
        }

        isSelected[cnt] = true;
        subSet(cnt+1);
        isSelected[cnt] = false;
        subSet(cnt+1);
    }


}
