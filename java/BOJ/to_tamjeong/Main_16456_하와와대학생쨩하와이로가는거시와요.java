package BOJ.to_tamjeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16456_하와와대학생쨩하와이로가는거시와요 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        travel();
    }

    static void travel() {
        int[] dpArr = new int[50_001];
        dpArr[1] = 1;   // 첫 번째 섬은 무조건 한 번의 경우
        dpArr[2] = 1;   // 초기에는 2번째 섬으로 가는 경우도 첫 번째 섬에서 한 칸 이동밖에 없음
        dpArr[3] = 2;   // 첫 번째 섬에서 두 칸 뛰기, 두 번째 섬에서 한 칸 뛰기로 두 가지 경우
        // 점화식 : 이전 섬에서의 이동(i-1) + 세 칸 전 섬에서의 이동(두 칸 과 이전 섬으로의 이동은 재방문 불가 조건 때문에 2 -> -1 -> 2 와 같이 세트화 됨.)
        for (int i = 4; i <= n; i++) dpArr[i] = (dpArr[i-3] + dpArr[i-1]) % 1_000_000_009;
        System.out.println(dpArr[n]);
    }

}
