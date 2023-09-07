package BOJ.class2p;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_실버4_10845_큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    queue.offer(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if (!queue.isEmpty()) System.out.println(queue.poll());
                    else System.out.println(-1);
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if (queue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if (!queue.isEmpty()) System.out.println(queue.peek());
                    else System.out.println(-1);
                    break;
                case "back":
                    if (!queue.isEmpty()) System.out.println(queue.peekLast());
                    else System.out.println(-1);
                    break;
            }
        }
    }

}
