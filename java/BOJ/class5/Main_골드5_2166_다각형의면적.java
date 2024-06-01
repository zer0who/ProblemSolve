package BOJ.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_골드5_2166_다각형의면적 {

    static int n;
    static List<int[]> axisList;

    public static void main(String[] args) throws IOException {
        init();
        calc();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        axisList = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            axisList.add(new int[] {x, y});
        }
        axisList.add(axisList.get(0));
    }

    static void calc() {
        long sum = 0;
        for (int i = 0; i < axisList.size()-1; i++) {
            sum += 1l * axisList.get(i)[0] * axisList.get(i+1)[1] - 1l * axisList.get(i)[1] * axisList.get(i+1)[0];
        }
        sum = Math.abs(sum);
        System.out.printf("%.1f", 1d*Math.abs(sum)/2);
    }

}
