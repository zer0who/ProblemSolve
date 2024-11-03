package SSAFY.study.algo.week60;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {

    static int S, P;
    static String dnaString;
    static Map<Character, Integer> needACGT;

    public static void main(String[] args) throws IOException {
        init();
        countPossible();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        dnaString = br.readLine();
        needACGT = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        needACGT.put('A', Integer.parseInt(st.nextToken()));
        needACGT.put('C', Integer.parseInt(st.nextToken()));
        needACGT.put('G', Integer.parseInt(st.nextToken()));
        needACGT.put('T', Integer.parseInt(st.nextToken()));
    }

    static void countPossible() {
        Map<Character, Integer> acgtMap = new HashMap<>();  // 현재 윈도우 안에 있는 A, C, G, T 개수 카운트
        acgtMap.put('A', 0);
        acgtMap.put('C', 0);
        acgtMap.put('G', 0);
        acgtMap.put('T', 0);
        int fulfillCount = 0;   // A, C, G, T 만족하는 개수 카운트
        char c;
        for (int i = 0; i < P; i++) {   // 첫 글자부터 P개까지 a, c, g, t 개수 저장
            c = dnaString.charAt(i);
            if (!acgtMap.containsKey(c)) continue;  // A, C, G, T 외에는 체크 안함
            acgtMap.put(c, acgtMap.get(c)+1);
        }
        for (char key : needACGT.keySet()) if (acgtMap.get(key) >= needACGT.get(key)) fulfillCount++;   // 충족하는 단어마다 충족 카운트 +1
        int count = (fulfillCount == 4)? 1:0;   // 제일 첫 윈도우가 조건 충족하는 지 여부에 따라 0 or 1로 초기화

        char outChar, inChar;
        for (int i = P; i < S; i++) {
            inChar = dnaString.charAt(i);
            if (acgtMap.containsKey(inChar)) {
                acgtMap.put(inChar, acgtMap.get(inChar) + 1);
                if (acgtMap.get(inChar) == needACGT.get(inChar)) fulfillCount++;    // 딱 조건 충족 개수가 됐을 때 fullfillCount +1
            }
            outChar = dnaString.charAt(i-P);
            if (acgtMap.containsKey(outChar)) {
                acgtMap.put(outChar, acgtMap.get(outChar) - 1);
                if (acgtMap.get(outChar) == needACGT.get(outChar)-1) fulfillCount--;  // 조건 충족 카운트보다 딱 한 개만큼 작아졌다면 fullfillCount -1
            }
            if (fulfillCount == 4) count++; // 조건 모두 충족한다면 count+1
        }

        System.out.println(count);
    }

}
