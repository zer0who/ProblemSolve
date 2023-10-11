package SSAFY.certificateA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {

    static int answer;
    static int D, W, K; // D: 두께, W: 가로크기, K: 합격 기준
    static int[][] film;    // 0 : A, 1 : B
    static boolean[] isSelected;    // 약품 넣게 고른 행
    static int[] medicine = {0, 1}; // 부분집합으로 행 고르고, 그 행들에 무슨 약을 넣을지 중복순열로 판단할 때 쓰기 위한 약 정보

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            init(br);
            if (checkPassed(film)) answer = 0;  // 처음에 합격이면 정답 0 고정
            else subSet(0); // 아니면 부분집합으로 골라서 약품 투여, 정답 갱신

            sb.append(answer);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = 0;
        D = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        film = new int[D][W];
        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                film[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static boolean checkPassed(int[][] testFilm) {    // 성능검사 합격했는지 체크
        int passColCnt = 0;    // 합격한 열 개수
        for (int j = 0; j < W; j++) {   // 열 별로 체크함
            int temp = 0;   // 연속으로 몇 개의 특성이 존재하는지 체크할 정수
            for (int i = 0; i < D-1; i++) {
                if (testFilm[i][j] == testFilm[i+1][j]) temp += 1;
                else temp = 0;
                if (temp >= K-1) {
                    passColCnt += 1;
                    break;
                }
            }
        }
        if (passColCnt == W) return true;   // 모든 셀이 합격이면 참

        return false;
    }

    static int[][] injection(List<Integer> selectedRow) { // medicine : 0 or 1
        int[][] testFilm = new int[D][W];
        for (int i = 0; i < D; i++) {   // 필름 값 복사
            for (int j = 0; j < W; j++) {
                testFilm[i][j] = film[i][j];
            }
        }


        int medicine = 0;
        for (int s = 0; s < selectedRow.size(); s++) {
            int row = selectedRow.get(s);
            for (int i = 0; i < W; i++) {   // 해당 행에 값 삽입
                testFilm[row][i] = 0;   // 여기에 중복 순열로 뽑은 값 할당해주면 되는데... 어떻게 할지 내일 생각해보자
            }
        }

        return testFilm;
    }

    static void subSet(int cnt) {
        if (cnt == D+1) { // 두께만큼 골랐으면
            List<Integer> selectedRow = new ArrayList<>();
            for (int i = 0; i < D; i++) if (isSelected[i]) selectedRow.add(i);
            if (selectedRow.size() < 2) return;    // 2개 이하로 골랐으면 함수 종료

            int[][] testFilm = injection(selectedRow);

            return;
        }

        isSelected[cnt] = true;
        subSet(cnt + 1);
        isSelected[cnt] = false;
        subSet(cnt + 1);
    }

}
