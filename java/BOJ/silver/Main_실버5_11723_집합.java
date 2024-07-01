package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_실버5_11723_집합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int[] set = new int[21];    // idx: 0 ~ 20
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String inputCommand = input[0];
            if (inputCommand.equals("all")) {    // all 이면 S를 1 ~ 20 집합으로.
                for (int j = 1; j <= 20; j++) {
                    set[j] = 1;
                }
            } else if (inputCommand.equals("empty")) {  // empty이면 S를 공집합으로.
                set = new int[21];
            } else {
                int inputNumber = Integer.parseInt(input[1]);
                switch (inputCommand){
                    case "add":
                        set[inputNumber] = 1;
                        break;
                    case "remove":
                        set[inputNumber] = 0;
                        break;
                    case "check":
                        if (set[inputNumber] == 1) sb.append(1).append("\n");
                        else sb.append(0).append("\n");
                        break;
                    case "toggle":
                        if (set[inputNumber] == 1) set[inputNumber] = 0;    // x가 있으면 제거
                        else set[inputNumber] = 1;  // x가 없으면 추가
                        break;

                }
            }
        }
        System.out.println(sb);
    }

}
