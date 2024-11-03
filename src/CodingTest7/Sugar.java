package CodingTest7;

import java.util.Scanner;

public class Sugar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bag = sc.nextInt(); // 사용자가 입력한 설탕의 무게 (킬로그램 단위)
        int num = -1;
        
        for(int i = bag/5; i>=0; i--) {
        	int remainder = bag - (i*5);
        	if(remainder%3 == 0) {
        		num = i + remainder/3;
        		break;
        	}
        }
        System.out.println(num);
    }
}