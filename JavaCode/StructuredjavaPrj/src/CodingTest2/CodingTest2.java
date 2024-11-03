package CodingTest2;

import java.util.Scanner;

public class CodingTest2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("테스트케이스를 입력하시오:");
        int testcase = sc.nextInt();

        int[][] arr = new int[testcase][2];

        for (int i = 0; i < testcase; i++) {
            System.out.println("n을 입력하시오:");
            int n = sc.nextInt();
            
            // fibonacciCount 호출 및 결과 저장
            int[] result = Fibonacci.fibonacciCount(n);
            arr[i][0] = result[0]; // n == 0 호출 횟수 저장
            arr[i][1] = result[1]; // n == 1 호출 횟수 저장
        }

        // 결과 출력
        for (int i = 0; i < testcase; i++) {
            System.out.println("테스트케이스 " + (i + 1) + ": n==0 호출 횟수 = " + arr[i][0] + ", n==1 호출 횟수 = " + arr[i][1]);
        }
        
        sc.close(); // Scanner 종료
    }

}