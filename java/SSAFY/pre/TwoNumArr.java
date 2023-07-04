package SSAFY.pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoNumArr {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = makeNumArr(br, st, N);
            int[] B = makeNumArr(br, st, M);


        }
    }

    public static int[] makeNumArr(BufferedReader br, StringTokenizer st, int size) throws IOException {
        int[] numArr = new int[size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        return numArr;
    }

}
