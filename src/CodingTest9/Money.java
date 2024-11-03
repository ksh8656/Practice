package CodingTest9;

import java.util.Scanner;

public class Money {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int num = sc.nextInt();
		int money = sc.nextInt();
		int[] value = new int[num];
		
		for(int i=0; i<num; i++) {
			value[i] = sc.nextInt();
		}
		
		for(int i = num-1; i>-1; i--) {
			if(value[i]<=money) {
				sum += money/value[i];
				money%=value[i];
			}
		}
		
		System.out.println(sum);
		
		sc.close();
	}

}
