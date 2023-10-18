package SSAFY.study.algo.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main_골드4_7662_이중우선순위큐 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순, 최소 힙
            PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < N; i++) {
                String[] command = br.readLine().split(" ");
                if (command[0].equals("D")) {
                    if (pq.isEmpty()) continue;
                    if (command[1].equals("-1")) {   // 최소값 제거
                        int polled = pq.poll();
                        rpq.remove(new Integer(polled));
                    } else if (command[1].equals("1")) {
                        int polled = rpq.poll();
                        pq.remove(new Integer(polled));
                    }
                    continue;
                }   // 삭제 연산
                pq.offer(Integer.parseInt(command[1]));
                rpq.offer(Integer.parseInt(command[1]));
            }

            if (pq.isEmpty()) sb.append("EMPTY");
            else {
                sb.append(rpq.poll()).append(" ").append(pq.poll());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
