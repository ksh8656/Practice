package CodingTest2;

public class Fibonacci {
	
	public static int[] fibonacciCount(int n) {
	    int[] count = new int[2];  // count[0]: n==0 호출 횟수, count[1]: n==1 호출 횟수

	    if (n == 0) {
	        count[0] = 1;  // n이 0일 때
	    } else if (n == 1) {
	        count[1] = 1;  // n이 1일 때
	    } else {
	        // 재귀적으로 피보나치 수열 계산 및 호출 횟수 누적
	        int[] count1 = fibonacciCount(n - 1);
	        int[] count2 = fibonacciCount(n - 2);
	        
	        // 두 호출 결과를 합산하여 반환
	        count[0] = count1[0] + count2[0];
	        count[1] = count1[1] + count2[1];
	    }
	    return count;
	}

}
