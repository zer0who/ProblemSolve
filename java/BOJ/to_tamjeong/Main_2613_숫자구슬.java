package BOJ.to_tamjeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2613_숫자구슬 {

    static int N, M;
    static int[] beads;
    static int lower, upper;
    static int[] groupBeads;    // 정답일 때 그룹 내 구슬 개수 저장용 배열

    public static void main(String[] args) throws IOException {
        init();
        findCase();
        StringBuilder sb = new StringBuilder();
        sb.append(lower).append("\n");
        for (int i = 0; i < M; i++) sb.append(groupBeads[i]).append(" ");
        System.out.println(sb);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        beads = new int[N];
        lower = 301;  // 모든 숫자구슬의 합 중 최솟값(초기 최솟값은 구슬 한 개를 그룹으로 엮었을 때를 가정함)
        upper = 0;  // 모든 숫자구슬의 합 중 최댓값(초기 최댓값은 구슬 모두를 한 그룹으로 엮었을 때를 가정함)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
            lower = Math.min(lower, beads[i]);
            upper += beads[i];
        }
        groupBeads = new int[M];
    }

    static void findCase() {
        int mid;    // 중간 값
        boolean divideResult;
        while (lower < upper) {
            mid = (lower + upper) / 2;
            divideResult = divideGroup(mid);
            if (divideResult) upper = mid;  // M개의 그룹으로 묶인 경우이므로 상한선을 낮춰서 기준 값(mid)을 내려 줌
            else lower = mid+1;   // M개의 그룹으로 묶지 못한 경우이므로 하한선을 올려서 기준 값을 높여 줌
        }
    }

    static boolean divideGroup(int mid) {
        int[] tempGroupBeads = new int[M];  // 그룹 별 구슬의 개수 임시 저장
        int groupCount = 1;   // 몇 번 그룹까지 만들어졌는 지 체크할 변수, 기본적으로 전체 구슬으로 이루어진 그룹 한 개는 깔고 감.
        int checkedIndex = 0;   // 몇 개의 구슬을 그룹으로 역을 지 저장할 변수
        int tempSum = 0;    // 그룹으로 묶인 구슬들의 합
        for (int i = 0; i < N; i++) {   // 모든 구슬에 대해
            if (groupCount > M || beads[i] > mid) return false; // 이미 만드려는 그룹 개수를 초과했거나, 구슬 하나의 값이 기준값을 넘는 경우 -> 불가능한 경우, false 반환

            if (tempSum + beads[i] > mid || N-i <= M-groupCount) {  // 이때까지의 합이 기준값을 넘어서 그룹을 형성해야 하거나, 남은 구슬의 개수가 만들어야 하는 그룹의 수와 같은 경우 -> 그룹 형성 처리
                tempGroupBeads[groupCount-1] = checkedIndex;    // 그룹의 구슬 개수 저장
                groupCount++;   // 그룹 형성 처리
                checkedIndex = 1;   // 그룹 구슬 개수 1로 초기화
                tempSum = beads[i]; // 현재까지 합 현재 구슬 값으로 초기화
            } else {    // 아직 그룹이 기준 값을 넘지 않은 경우 -> 구슬 개수, 합 갱신만 수행
                checkedIndex++;
                tempSum += beads[i];
            }
        }

        if (groupCount > M) return false;  // M개의 그룹으로 못 묶는 경우

        tempGroupBeads[groupCount-1] = checkedIndex;    // 마지막 그룹은 개수가 저장되지 않은 상태이므로, 마지막 그룹에 구슬 개수 저장
        groupBeads = tempGroupBeads;    // 이분탐색의 로직 상 그룹을 만들 수 있는 경우의 맨 마지막 경우가 정답임. 그러므로 갱신

        return true;
    }

}
