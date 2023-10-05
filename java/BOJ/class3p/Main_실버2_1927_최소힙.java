package BOJ.class3p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_실버2_1927_최소힙 {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (heap.isEmpty()) sb.append(0).append("\n");
                else sb.append(heap.poll()).append("\n");
            }
            else heap.offer(input);
        }
        System.out.println(sb);
    }

}
