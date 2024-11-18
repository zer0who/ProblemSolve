package SSAFY.study.algo.week60s.week62;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_22866_탑보기 {

    static int N;
    static int[] buildings;
    static int[] canSee;
    static int[] minCanSeeIndex;

    public static void main(String[] args) throws IOException {
        init();
        countCanSee();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) buildings[i] = Integer.parseInt(st.nextToken());
        canSee = new int[N];    // 각 빌딩이 볼 수 있는 빌딩 수 저장할 배열
        minCanSeeIndex = new int[N];    // 볼 수 있는 빌딩들 중 인덱스가 가장 작은 빌딩 저장할 배열
        Arrays.fill(minCanSeeIndex, 100_001); // 우선 각 빌딩의 볼 수 있는 빌딩 인덱스 최소값은 10만으로 초기화
    }

    static void countCanSee() {
        Stack<Integer> canSeeLeftStack = new Stack<>(); // 현재 시점에서 볼 수 있는 왼쪽 빌딩들 인덱스 저장한 스택
        Stack<Integer> canSeeRightStack = new Stack<>();    // 볼 수 있는 오른쪽 빌딩들 인덱스 저장한 스택
        canSeeLeftStack.push(0); // 제일 왼쪽 빌딩 넣고 시작
        canSeeRightStack.push(N-1);  // 제일 오른쪽 빌딩 넣고 시작
        for (int i = 1; i < N; i++) {
            canSeeLeftStack = countCanSeeAtNowBuilding(canSeeLeftStack, i);
            canSeeRightStack = countCanSeeAtNowBuilding(canSeeRightStack, (N-1)-i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (canSee[i] == 0) sb.append(0).append("\n");
            else {
                sb.append(canSee[i] + " " + (minCanSeeIndex[i]+1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static Stack<Integer> countCanSeeAtNowBuilding(Stack<Integer> canSeeStack, int index) {
        while (!canSeeStack.isEmpty() && buildings[canSeeStack.peek()] <= buildings[index]) canSeeStack.pop(); // 현재 빌딩보다 높이가 낮거나 같은 빌딩들은 못 봄
        canSee[index] += canSeeStack.size();    // 현재 스택 내에 있는 빌딩 개수만큼 볼 수 있음을 표시
        if (!canSeeStack.isEmpty() && Math.abs(canSeeStack.peek()-index) <= Math.abs(minCanSeeIndex[index]-index)
            && canSeeStack.peek() < minCanSeeIndex[index]) minCanSeeIndex[index] = canSeeStack.peek(); // 볼 수 있는 빌딩 중 가장 가까운 빌딩 번호 저장
        canSeeStack.push(index); // 스택에 현재 빌딩 넣어줌

        return canSeeStack;
    }

}
