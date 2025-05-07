package chapter06.level2.primenumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
페이지 211
 */
public class PrimeNumberAnswer {
    // 소수 검사
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 재귀 메서드
    private Set<Integer> getPrimes(int acc, List<Integer> numbers) {
        // 종료 조건, 점화식 구현
        Set<Integer> primes = new HashSet<>();
        // 점화식 구현
        if (isPrime(acc)) primes.add(acc);
        // if (numbers.isEmpty()) return primes; // acc 의 소수 여부에 따라 적절한 집합 반환

        // 상태 전이 구현
        for (int i = 0; i < numbers.size(); i++) {
            // numbers.get(i)로 상태 전이 진행
            int nextAcc = acc * 10 + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i); // 전이되는 상태의 numbers 는 방금 사용한 숫자를 제외하고 넘겨줘야 한다.
            primes.addAll(getPrimes(nextAcc, nextNumbers));
        }

        return primes;
    }

    public int solution(String nums) {
        List<Integer> numbers = nums.chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());
        return getPrimes(0, numbers).size();
    }

    public static void main(String[] args) {
        PrimeNumberAnswer pn = new PrimeNumberAnswer();
        System.out.println(pn.solution("17"));
        System.out.println(pn.solution("011"));
    }
}
