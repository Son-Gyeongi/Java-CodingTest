package chapter06.level2.primenumber;

import java.util.HashSet;
import java.util.Set;

/*
페이지 211
문제 풀이 최적화2
List 를 복사하고 원소를 하나씩 제거하는 경우 O(N^2)의 시간 복잡도가 소요되는 걸 개선
 */
public class PrimeNumberAnswer3 {
    // 소수 검사
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 재귀 메서드
    private void getPrimes(int acc, int[] numbers, boolean[] inUsed, Set<Integer> primes) {
        if (isPrime(acc)) primes.add(acc);

        for (int i = 0; i < numbers.length; i++) {
            if (inUsed[i]) continue;

            // numbers[i] 사용
            int nextAcc = acc * 10 + numbers[i];

            // 재귀 호출
            inUsed[i] = true;
            getPrimes(nextAcc, numbers, inUsed, primes);
            inUsed[i] = false;
        }
    }

    public int solution(String nums) {
        Set<Integer> primes = new HashSet<>();
        int[] numbers = nums.chars().map(c -> c - '0').toArray();
        getPrimes(0, numbers, new boolean[numbers.length], primes);
        return primes.size();
    }

    public static void main(String[] args) {
        PrimeNumberAnswer3 pn = new PrimeNumberAnswer3();
        System.out.println(pn.solution("17"));
        System.out.println(pn.solution("011"));
    }
}
