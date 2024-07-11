package BOJ.class5p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_골드3_11049_행렬곱셈순서 {

    static int N;
    static int[][] matrixArr;

    public static void main(String[] args) throws IOException {
        init();
        calcMatrixMin();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrixArr = new int[N][2];
        int r, c;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            matrixArr[i] = new int[] {r, c};
        }
    }

    static void calcMatrixMin() {
        int[][] dpArr = new int[N][N];  // i ~ j 까지 행렬의 곱 연산 횟수 중 최소 횟수를 저장할 배열

        for (int d = 2; d <= N; d++) {   // d: i번째 행렬에서 몇 번째 떨어진 행렬까지의 최솟값을 저장할 지에 대한 간격( i ~ i+d )
            for (int i = 0; i <= N-d; i++) {   // i: 간격이 d인 것만큼 구할 수 있는 범위 안에서 시작점
                dpArr[i][i+d-1] = Integer.MAX_VALUE; // 우선 해당 행렬의 곱셈 횟수 최소 값은 무한대로 지정
                for (int j = i; j < i+d-1; j++) {   // j: i ~ i+d-1 중간의 값
                    dpArr[i][i+d-1] = Math.min(dpArr[i][i+d-1], dpArr[i][j] + dpArr[j+1][i+d-1] + (matrixArr[i][0] * matrixArr[j][1] * matrixArr[i+d-1][1]));
                    // 구간 내에서 인덱스 1씩 증가시키며 그때까지 구해진 최솟값들을 이용함.
                    // 짤린 구간 안에서 다시 중간 값을 기준으로 다시 두 구간으로 나누고 그에 대해 곱셈 횟수와 각 구간 최솟값들을 합해주며 최솟값 갱신
                }
            }
        }

        System.out.println(dpArr[0][N-1]);
    }

}
