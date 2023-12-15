package SSAFY.study.algo.week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드4_9019_DSLR {

    static int A;
    static int B;
    static int minCount;    // 최소 횟수 저장할 변수
    static List<String> command;  // 최소 횟수에서의 명령어
    static boolean[] isVisited; // 이미 만들었던 숫자인지 체크

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            init(br);
            dfs(A, 0, new ArrayList<>());
            for (int i = 0; i < command.size(); i++) {
                sb.append(command.get(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        minCount = Integer.MAX_VALUE;
        command = new ArrayList<>();
        isVisited = new boolean[10001];
    }

    static int rotateA(int a, String command) {
        String aString = String.valueOf(a);
        if (a < 1000 && a >= 100) aString = "0" + aString;  // 회전 전 자릿수에 따른 0 추가 로직
        else if (a < 100 && a >= 10) aString = "00" + aString;
        else if (a < 10 && a >= 0) aString = "000" + aString;
        Deque<String> deque = new ArrayDeque<>();   // 우측 회전, 좌측 회전을 처리하기 위해 덱을 이용
        for (int i = 0; i < aString.length(); i++) {    // 회전을 위해 덱에 저장
            deque.offer(String.valueOf(aString.charAt(i)));
        }

        if (command.equals("L")) {
            deque.offer(deque.poll());
        } else if (command.equals("R")) {
            deque.offerFirst(deque.pollLast());
        }

        String result = "";
        while (!deque.isEmpty()) result += deque.poll();

        return Integer.parseInt(result);
    }

    static void dfs(int a, int cnt, List<String> tempCommand) { // A가 B와 같아질 때까지 시도하는 함수
        if (isVisited[a]) return;
        if (a == B) {   // 기저, a가 b와 같아짐
            System.out.println("answer: " + a);
            System.out.println(cnt);
            if (cnt < minCount) {
                minCount = cnt;
                command = new ArrayList<>();
                for (int i = 0; i < tempCommand.size(); i++) {
                    command.add(tempCommand.get(i));
                }
            }

            return;
        }
        isVisited[a] = true;

        // case D
        tempCommand.add("D");
        dfs((a*2) % 10000, cnt+1, tempCommand);
        tempCommand.remove(cnt);
        // case S
        tempCommand.add("S");
        dfs((a == 0) ? 9999:a-1, cnt+1, tempCommand);
        tempCommand.remove(cnt);
        // case L
        tempCommand.add("L");
        dfs(rotateA(a, "L"), cnt+1, tempCommand);
        tempCommand.remove(cnt);
        // case R
        tempCommand.add("R");
        dfs(rotateA(a, "R"), cnt+1, tempCommand);
        tempCommand.remove(cnt);
    }

}
