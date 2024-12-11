package SSAFY.study.algo.week60s.week64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_25565_딸기와토마토 {

    static int N, M, K;
    static int[][] seeds;
    static int seedCount;

    public static void main(String[] args) throws IOException {
        init();
        calcAnswer();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        seedCount = 0; // 뿌린 씨앗의 수
        int[] seedStart = new int[] {-1, -1};   // 가장 먼저 씨를 뿌리기 시작한 장소 저장
        seeds = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                seeds[i][j] = Integer.parseInt(st.nextToken());
                if (seeds[i][j] == 1) seedCount++;
            }
        }
    }

    static void calcAnswer() {
        int[] dirRow = new int[] {-1, 0, 1, 0};
        int[] dirCol = new int[] {0, 1, 0, -1};

        if (seedCount == 2*K) System.out.println(0);    // 씨앗 개수가 K * 2라면 겹치는 부분이 없음을 의미
        else if (seedCount == K) caseSame(dirRow, dirCol);  // 씨앗 개수가 가로나 세로 수와 같다면 모두 겹치게 뿌렸음을 의미, 이걸 먼저 처리해줘야 함. 안그럼 K가 1일 때 밑의 조건이랑 겹칠 수 있음.
        else if (seedCount == 2*K-1) caseCross(dirRow, dirCol);  // 씨앗 개수가 2 * K - 1이라면 겹치는 부분이 한군데임을 의미
        else caseOther(dirRow, dirCol);    // 씨앗이 세로 혹은 가로의 같은 줄에 모두가 아니라 일부분 겹쳐져 있는 경우
    }

    static void caseCross(int[] dirRow, int[] dirCol) {   // 교차로 심은 경우 출력 함수
        StringBuilder sb = new StringBuilder();
        sb.append(1).append("\n");
        for (int i = 0; i < N; i++) {   // 모든 좌표 탐색해서 겹치는 부분 찾기
            for (int j = 0; j < M; j++) {
                if (seeds[i][j] == 1) {
                    int nextRow, nextCol;
                    int nearCount = 0;  // 인접한 곳이 범위 밖이거나 씨인 곳이 2개 이상 있어야 교차점임
                    for (int d = 0; d < 4; d++) {
                        nextRow = i + dirRow[d];
                        nextCol = j + dirCol[d];
                        if (isOuted(nextRow, nextCol) || seeds[nextRow][nextCol] == 1) nearCount++;
                    }
                    if (nearCount == 4) {   // 교차점이면 출력 후 함수 종료
                        sb.append(i+1).append(" ").append(j+1);
                        System.out.println(sb);
                        return;
                    }
                }
            }
        }
    }

    static void caseSame(int[] dirRow, int[] dirCol) {    // 같은 장소에 씨앗 심었을 경우 출력
        StringBuilder sb = new StringBuilder();
        sb.append(K).append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (seeds[i][j] == 1) {
                    sb.append(i+1).append(" ").append(j+1).append("\n");
                    if (i+1 >= N || seeds[i+1][j] == 1) sb.append(appendAxisUntilEnd(i+1, N, new int[] {i, j}, 2, dirRow, dirCol));    // 세로 방향으로 심었을 경우
                    else if (j+1 >= M || seeds[i][j+1] == 1) sb.append(appendAxisUntilEnd(j+1, M, new int[] {i, j}, 1, dirRow, dirCol));   // 가로 방향으로 심었을 경우
                    System.out.println(sb);
                    return;
                }
            }
        }
    }

    static void caseOther(int[] dirRow, int[] dirCol) {   // 한 줄로 겹치는데, 모두 다가 아니라 일부분만 겹칠 경우
        StringBuilder sb = new StringBuilder();
        sb.append(K*2 - seedCount).append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (seeds[i][j] == 1) {
                    if (i+1 >= N || seeds[i+1][j] == 1) sb.append(appendAxisUntilEnd(i+(seedCount-K), N-(seedCount-K), new int[] {i, j}, 2, dirRow, dirCol));    // 세로 방향으로 심었을 경우
                    else if (j+1 >= M || seeds[i][j+1] == 1) sb.append(appendAxisUntilEnd(j+(seedCount-K), M-(seedCount-K), new int[] {i, j}, 1, dirRow, dirCol));   // 가로 방향으로 심었을 경우
                    System.out.println(sb);
                    return;
                }
            }
        }
    }

    static String appendAxisUntilEnd(int start, int end, int[] axis, int dir, int[] dirRow, int[] dirCol) {  // 시작점부터 끝점까지 좌표를 넣어주는 함수, dir은 상 우 하 좌 순
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            axis[0] += dirRow[dir];
            axis[1] += dirCol[dir];
            sb.append(axis[0] + 1).append(" ").append(axis[1] + 1).append("\n");
        }

        return sb.toString();
    }

    static boolean isOuted(int row, int col) {
        if ((0 <= row && row < N) && (0 <= col && col < M)) return false;
        return true;
    }

}
