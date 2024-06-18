package BOJ.class4pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_골드4_30805_사전순최대공통부분수열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int M = scanner.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = scanner.nextInt();
        }

        // 결과 계산
        List<Integer> result = findLargestLexicographicalCommonSubsequence(A, B);

        // 결과 출력
        if (!result.isEmpty()) {
            System.out.println(result.size());
            for (int num : result) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println(0);
        }

        scanner.close();
    }

    private static List<Integer> findLargestLexicographicalCommonSubsequence(int[] A, int[] B) {
        List<List<Integer>> subsequencesA = generateSubsequences(A);    // 각 배열에 대해 부분집합을 만듬.
        List<List<Integer>> subsequencesB = generateSubsequences(B);

        Set<List<Integer>> setA = new HashSet<>(subsequencesA); // 부분집합에 대한 중복 제거
        Set<List<Integer>> setB = new HashSet<>(subsequencesB);

        List<List<Integer>> commonSubsequences = new ArrayList<>();
        for (List<Integer> sub : setA) {
            if (setB.contains(sub)) {
                commonSubsequences.add(sub);
            }
        }

        commonSubsequences.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {    // 사전 순 정렬
                int size = Math.min(o1.size(), o2.size());
                for (int i = 0; i < size; i++) {
                    if (!o1.get(i).equals(o2.get(i))) { // 중간에 숫자로 사전 순 정렬이 정해지면 그대로 정렬
                        return o1.get(i) - o2.get(i);
                    }
                }
                return o1.size() - o2.size();   // 안정해지면 더 큰 수를 나중으로 판단
            }
        });

        return commonSubsequences.isEmpty() ? Collections.emptyList() : commonSubsequences.get(commonSubsequences.size() - 1);
    }

    private static List<List<Integer>> generateSubsequences(int[] array) {
        List<List<Integer>> subsequences = new ArrayList<>();
        subsequences.add(new ArrayList<>());

        for (int num : array) {
            int size = subsequences.size(); // 이전까지 만들어진 부분집합에 대해서
            for (int i = 0; i < size; i++) {    // 현재의 수를 이전까지 부분집합들에 더해서 넣어줌
                List<Integer> newSubsequence = new ArrayList<>(subsequences.get(i));
                newSubsequence.add(num);
                subsequences.add(newSubsequence);
            }
        }

        return subsequences;
    }

}
