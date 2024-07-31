package BOJ.class5pp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_골드3_1644_소수의연속합 {

    static int N;
    static List<Integer> primes;    // N이하의 소수들 저장할 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        findPrimes();
        if (primes.size() == 0) System.out.println(0);
        else calcCases();
    }

    static void findPrimes() {  // N이하의 소수들을 우선 모두 찾아내야함. 이때 N이 400만이므로 일반 반복문 이용(N^2), 일반 반복문을 이용한 제곱근 N 이하의 소수 판별(N*(N^(1/2)))은 사용 불가. 에라토스테네스의 체(Nlog(logN))) 이용해야 함.
        boolean[] isNotPrime = new boolean[N+1];
        primes = new ArrayList<>();
        if (N < 2) return;  // N이 1이하면 소수 판별 할 필요 없음.
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {   // 2부터 제곱근 N까지 반복, i를 제외한 i의 배수들을 제외시키는 방식
            if (isNotPrime[i]) continue;   // 이미 있는 값이면 건너 뜀
            for (int j = i*i; j < N+1; j = j+i) {   // 제곱수부터 시작, 다음 배수만큼 증가시키며 반복
                isNotPrime[j] = true;   // 이 수는 소수가 아님을 표시
            }
        }

        for (int i = 0; i < N+1; i++) if (!isNotPrime[i]) primes.add(i);    // 소수인 수만 추가
    }

    static void calcCases() {
        int answer = 0;
        int left = 0, right = 0;
        int sum = primes.get(0);

        while (right < primes.size() && left < primes.size()) {
            if (sum == N) answer += 1;
            if (right >= primes.size()-1 && left >= primes.size()-1) break;
            if (sum <= N) {
                if (right >= primes.size()-1) continue;
                right += 1;
                sum += primes.get(right);
            } else if (sum > N) {
                if (left >= primes.size()-1) continue;
                sum -= primes.get(left);
                left += 1;
            }
        }
        System.out.println(answer);
    }

}
