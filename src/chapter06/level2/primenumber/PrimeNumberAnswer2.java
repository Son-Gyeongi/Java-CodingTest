package chapter06.level2.primenumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
페이지 211
문제 풀이 최적화1
Set 을 반환하지 않고 매개변수로 전달해서 불필요한 원소 순회를 방지
 */
public class PrimeNumberAnswer2 {
    // 소수 검사
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 재귀 메서드
    // Set 을 반환하지 않고 매개변수로 전달해서 불필요한 원소 순회를 방지
    private void getPrimes(int acc, List<Integer> numbers, Set<Integer> primes) {
        if (isPrime(acc)) primes.add(acc);
        for (int i = 0; i < numbers.size(); i++) {
            int nextAcc = acc * 10 + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i); // 전이되는 상태의 numbers 는 방금 사용한 숫자를 제외하고 넘겨줘야 한다.
            getPrimes(nextAcc, nextNumbers, primes);
        }
    }

    public int solution(String nums) {
        Set<Integer> primes = new HashSet<>();
        List<Integer> numbers = nums.chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());
        getPrimes(0, numbers, primes);
        return primes.size();
    }

    public static void main(String[] args) {
        PrimeNumberAnswer2 pn = new PrimeNumberAnswer2();
        System.out.println(pn.solution("17"));
        System.out.println(pn.solution("011"));
    }
}
