package SSAFY.study.algo.week37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_골드4_10282_해킹 {

    static class Computer {
        
    }

    static class Depend {   // 간선이라고 생각하면 됨
        int no; // 컴퓨터의 번호
        int depends;    // 의존하는 컴퓨터 번호
        int s;  // s초 후 감염됨을 나타내는 변수

        public Depend(int no, int depends, int s) {
            this.no = no;
            this.depends = depends;
            this.s = s;
        }
    }
    static List<List<Depend>> dependList;   // 컴퓨터들의 의존성을 저장하는 리스트(간선, 내부의 리스트는 그 인덱스의 컴퓨터를 의존하는 컴퓨터들로)

    static int T;   // test case 수
    static int n, d, c; // n: 컴퓨터 개수, d: 의존성 개수, c: 해킹당한 컴퓨터 번호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {   // 각 TC들에 대해서
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            dependList = new ArrayList<>();
            for (int i = 0; i < n+1; i++) dependList.add(new ArrayList<>());

            for (int i = 0; i < d; i++) {   // d개의 의존성들에 대해 컴퓨터 리스트에 추가
                int a, b, s;
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                dependList.get(b).add(new Depend(a, b, s));
            }
        }
    }

    static void affection() {
        
    }

}
