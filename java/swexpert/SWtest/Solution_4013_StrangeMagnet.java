package swexpert.SWtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_4013_StrangeMagnet {

    // 0: N극, 1: S극
    // 1 - 2 의 1 맞닿은 위치 : 2
    // 2 - 1 의 2 맞닿은 위치 : 6
    // 2 - 3 의 2 맞닿은 위치 : 2
    // 3 - 2 의 3 맞닿은 위치 : 6
    // 3 - 4 의 3 맞닿은 위치 : 2
    // 4 - 3 의 4 맞닿은 위치 : 2
    // 1: 시계 방향(Deque), -1: 반시계 방향(Queue)
    private static StringBuilder sb = new StringBuilder();
    private static int K;   // 회전 횟수
    private static int[][] magnets; // 자석 정보 담을 배열
    private static int[][] rotations;   // 회전 정보


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("/Users/yeonghukim/PS/ProblemSolve/java/swexpert/SWtest/4013_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            K = Integer.parseInt(br.readLine());    // 회전 횟수
            initMagnets(br);    // 자석들 초기화
            initRotations(br);  // 회전 정보 초기화
            doRotate();

            sb.append(sumMagnets());    // 자석들 마지막 모습에서 결과 계산
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void initMagnets(BufferedReader br) throws Exception { // 자석 정보 초기화
        StringTokenizer st;
        magnets = new int[4][8];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                magnets[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void initRotations(BufferedReader br) throws Exception {
        StringTokenizer st;
        rotations = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                rotations[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void doRotate() {    // 주어진 회전 정보에 대해서 회전 여부 체크
        for (int i = 0; i < rotations.length; i++) {    // 회전 횟수 동안
            List<int[]> magnetsToRotate = new ArrayList<>();  // 회전시켜야하는 자석 정보 저장할 리스트
            int magnetNumber = rotations[i][0] - 1; // 자석 번호 인덱스화
            int direction = rotations[i][1];
            int left = magnetNumber;    // 왼쪽 자석들 검사용 인덱스
            int right = magnetNumber;   // 오른쪽 자석들 검사용 인덱스
            magnetsToRotate.add(new int[] {magnetNumber, direction});
            int tempDirLeft = direction;
            int tempDirRight = direction;
            while (left > 0) {  // 왼쪽 자석들 검사
                if (magnets[left][6] == magnets[left-1][2]) break;  // 극이 같으면 탐색 멈춤
                tempDirLeft *= -1;
                magnetsToRotate.add(new int[] {left-1, tempDirLeft});    // 극이 다른 자석 리스트에 넣어줌
                left -= 1;
            }
            while (right < 3) {  // 왼쪽 자석들 검사
                if (magnets[right][2] == magnets[right+1][6]) break;  // 극이 같으면 탐색 멈춤
                tempDirRight *= -1;
                magnetsToRotate.add(new int[] {right+1, tempDirRight});    // 극이 다른 자석 리스트에 넣어줌
                right += 1;
            }
            for (int j = 0; j < magnetsToRotate.size(); j++) {
                rotateMagnets(magnets[magnetsToRotate.get(j)[0]], magnetsToRotate.get(j)[1]);
            }
        }
    }

    private static void rotateMagnets(int[] magnet, int direction) {   // 회전해야하는 자석의 방향으로 회전, 1: 시계, -1: 반시계
        if (direction == 1) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int m : magnet) {
                deque.offer(m); // 우선 덱에 순서대로 다 넣어줌.
            }
            deque.addFirst(deque.removeLast()); // 마지막 날을 뽑아서 처음으로(시계방향 회전)
            for (int i = 0; i < 8; i++) {
                magnet[i] = deque.poll();
            }
        }
        else {  // 시계방향이면
            Queue<Integer> queue = new ArrayDeque<>();
            for (int m : magnet) {
                queue.offer(m); // 우선 덱에 순서대로 다 넣어줌.
            }
            queue.offer(queue.poll()); // 처음 날을 마지막 날로(반시계방향 회전)
            for (int i = 0; i < 8; i++) {
                magnet[i] = queue.poll();
            }
        }
    }

    private static int sumMagnets() {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (magnets[i][0] == 1) {   // S극이면
                result += Math.pow(2, i);
            }
        }

        return result;
    }

}
