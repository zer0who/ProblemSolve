package BOJ.SAMSUNG_KICHOOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드5_21608_상어초등학교 {

    static int[] dirRow = new int[] {-1, 1, 0, 0};  // 인접한 칸 탐색을 위한 방향, 상 하 좌 우
    static int[] dirCol = new int[] {0, 0, -1, 1};

    static int N;
    static int[][] classRoom;   // 좌석 배치된 교실
    static List<int[]> preferenceList;  // 각 학생들의 선호도, 각 배열의 0번 인덱스는 학생의 번호
    static List<int[]> markedAxisList;  // 지정된 좌석의 좌표를 지정된 순서대로 저장한 리스트

    public static void main(String[] args) throws IOException {
        init();
        markStudents();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        classRoom = new int[N][N];
        preferenceList = new ArrayList<>();
        int[] preferences;
        StringTokenizer st;
        for (int i = 0; i < Math.pow(N, 2); i++) {
            st = new StringTokenizer(br.readLine());
            preferences = new int[5];
            for (int j = 0; j < 5; j++) preferences[j] = Integer.parseInt(st.nextToken());
            preferenceList.add(preferences);
        }
        markedAxisList = new ArrayList<>();
    }

    static void markStudents() {    // 학생들을 자리에 배치하는 로직
        int studentsNumber;
        List<int[]> maxPreferenceList;
        int[] markAxis; // 학생을 배치할 좌석의 좌표
        for (int[] preference : preferenceList) {   // 각 학생들에 대해서 수행
            studentsNumber = preference[0];
            maxPreferenceList = findMaxPreferenceNumberAxis(preference);
//            System.out.println(studentsNumber);
//            for (int i = 0; i < maxPreferenceList.size(); i++) System.out.println(Arrays.toString(maxPreferenceList.get(i)));
            if (maxPreferenceList.size() == 1) markAxis = maxPreferenceList.get(0);    // 1번 규칙에서 배치할 좌석이 정해졌을 경우 좌석 배치
            else markAxis = findFinalAxis(maxPreferenceList);    // 1번에서 좌석 배치가 끝나지 않았을 경우 2, 3번 규칙 수행
            classRoom[markAxis[0]][markAxis[1]] = studentsNumber;
            markedAxisList.add(markAxis);
        }
        System.out.println(calcSatisfaction());
    }

    static List<int[]> findMaxPreferenceNumberAxis(int[] preference) {
        List<int[]> maxPreferenceList = new ArrayList<>();  // 각 학생 별 좋아하는 학생들이 많이 인접한 좌표 저장하는 리스트
        int maxCount = 0;   // 좋아하는 학생들이 인접한 카운트 중 가장 많은 수 저장할 변수
        int tempCount;
        int nextRow, nextCol;
        for (int i = 0; i < N; i++) {   // 교실의 각 자리에 대해서 수행
            for (int j = 0; j < N; j++) {
                tempCount = 0;
                if (classRoom[i][j] != 0) continue; // 이미 자리가 선점돼있으면 건너 뜀
                for (int d = 0; d < 4; d++) {   // 각 자리 별 인접한 자리 탐색
                    nextRow = i + dirRow[d];
                    nextCol = j + dirCol[d];
                    if (isOuted(nextRow, nextCol)) continue;    // 범위 밖이면 건너 뜀
                    for (int p = 1; p < 5; p++) if (classRoom[nextRow][nextCol] == preference[p]) tempCount++;  // 좋아하는 학생이 인접한 칸에 앉아있으면 카운트 + 1
                }
                if (tempCount > maxCount) { // 현재까지 가장 많은 좋아하는 학생이 인접해있는 칸보다 더 많은 좋아하는 학생이 인접해있는 경우, 모두 갱신
                    maxCount = tempCount;
                    maxPreferenceList = new ArrayList<>();
                    maxPreferenceList.add(new int[] {i, j});
                } else if (tempCount == maxCount) maxPreferenceList.add(new int[] {i, j}); // 현재 값이랑 같은 경우에는 그냥 리스트에 현재 좌표 추가
            }
        }

        return maxPreferenceList;
    }

    static int[] findFinalAxis(List<int[]> maxPreferenceList) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];   // 같은 행에 있는 경우 왼쪽 열에 있는 것을 우선으로
                return o1[0] - o2[0];   // 그 외에는 윗 행에 있는 좌표를 우선으로
            }
        });

        int maxCount = 0;
        int nextRow, nextCol;
        for (int[] preference : maxPreferenceList) {
            int tempCount = 0;
            for (int d = 0; d < 4; d++) {
                nextRow = preference[0] + dirRow[d];
                nextCol = preference[1] + dirCol[d];
                if (isOuted(nextRow, nextCol)) continue;    // 범위를 넘으면 건너 뜀
                if (classRoom[nextRow][nextCol] == 0) tempCount++;
            }
            if (tempCount > maxCount) {
                maxCount = tempCount;
                pq.clear();
                pq.offer(preference);
            } else if (tempCount == maxCount) pq.offer(preference);
        }

        return pq.poll();
    }

    static int calcSatisfaction() {
        int satisfaction = 0;
        int nextRow, nextCol;
        int tempCount;
        for (int i = 0; i < markedAxisList.size(); i++) {
            tempCount = 0;
            for (int d = 0; d < 4; d++) {   // 인접한 칸 탐색
                nextRow = markedAxisList.get(i)[0] + dirRow[d];
                nextCol = markedAxisList.get(i)[1] + dirCol[d];
                if (isOuted(nextRow, nextCol)) continue;
                for (int j = 1; j < 5; j++) {   // 인접한 칸에 좋아하는 학생이 포함돼있으면 카운트 + 1
                    if (preferenceList.get(i)[j] == classRoom[nextRow][nextCol]) tempCount++;
                }
            }
            satisfaction += (int) Math.pow(10, tempCount-1);
        }

        return satisfaction;
    }

    static boolean isOuted(int row, int col) {
        if ((0 <= row && row < N) && (0 <= col && col < N)) return false;
        return true;
    }

}
