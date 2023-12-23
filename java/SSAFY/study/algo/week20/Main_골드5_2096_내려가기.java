package SSAFY.study.algo.week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_골드5_2096_내려가기 {

    // 문제 모양만 보고 든 생각: 완탐
    // 근데 좀 이상함 쉬워보임 -> 메모리 제한 봤더 4MB(자바는 256MB) 이러고 있음
    // N의 최대 크기: 100,000
    // 완탐을 위한 배열 만들면 (100,000 * 100,000 * 4byte) / (1024 * 1024) = 약 381470MB 이러고 있음
    // 완탐을 생각했지만 메모리를 줄여야한다(이 문제의 경우가 메모리 제한이고 시간을 줄여야하는 경우에도 마찬가지) => 메모이제이션

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < )
    }

}
