package CodingTest23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class FindPrime {
    // 고유한 소수를 저장하기 위한 Set
    private Set<Integer> primes = new HashSet<>();

    // 입력 문자열에서 가능한 모든 소수를 찾는 메인 메서드
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        generateNumbers(numbers, "", visited);
        return primes.size();
    }

    // 가능한 모든 숫자 조합을 생성하는 재귀 메서드
    private void generateNumbers(String numbers, String current, boolean[] visited) {
        // 현재 문자열이 비어있지 않으면 소수인지 확인
        if (!current.isEmpty()) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) {
                primes.add(num); // 소수라면 Set에 추가
            }
        }

        // 입력 문자열의 각 문자에 대해 반복
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) { // 해당 문자가 아직 사용되지 않았다면
                visited[i] = true; // 문자를 사용했음으로 표시
                generateNumbers(numbers, current + numbers.charAt(i), visited); // 새로운 조합으로 재귀 호출
                visited[i] = false; // 백트래킹을 위해 문자 사용 표시 해제
            }
        }
    }

    // 주어진 숫자가 소수인지 확인하는 메서드
    private boolean isPrime(int number) {
        if (number <= 1) { // 1 이하의 숫자는 소수가 아님
            return false;
        }
        // 2부터 해당 숫자의 제곱근까지 나누어 소수 여부 확인
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) { // 나누어 떨어지면 소수가 아님
                return false;
            }
        }
        return true; // 나누어 떨어지지 않으면 소수임
    }

    // 솔루션을 테스트하기 위한 메인 메서드
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter numbers: ");
        String numbers = br.readLine();
        FindPrime findPrimeNumbers = new FindPrime();
        System.out.println("Number of primes: " + findPrimeNumbers.solution(numbers));
    }
}

