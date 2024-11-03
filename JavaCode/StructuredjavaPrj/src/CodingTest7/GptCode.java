package CodingTest7;

import java.util.Scanner;

public class GptCode {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int bag = sc.nextInt(); // 사용자가 입력한 설탕의 무게 (킬로그램 단위)
	        int num = -1; // 초기값으로 -1 설정 (최종적으로 배달할 수 없으면 -1 출력)

	        // 5kg 봉지를 최대한 많이 사용하여 반복을 수행
	        for (int i = bag / 5; i >= 0; i--) {
	            int remainder = bag - (i * 5); // 5kg 봉지 사용 후 남은 무게 계산
	            if (remainder % 3 == 0) { // 나머지가 3kg 봉지로 나눠떨어질 경우
	                num = i + (remainder / 3); // 5kg 봉지와 3kg 봉지의 총합을 구함
	                break; // 조건을 만족하면 반복을 종료
	            }
	        }

	        System.out.println(num); // 최종적으로 필요한 봉지의 수 출력
	    }
}