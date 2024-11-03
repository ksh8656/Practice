package CodingTest3;

import java.util.Scanner;

public class BabyPrincess {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("테스크케이스의 개수를 입력하시오:");
		int testcase = sc.nextInt();
		int[] num1 = new int[testcase];
		
		
		for(int i = 0; i<testcase; i++) {
			int num = 0; //행성을 지나간 횟수
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			
			int planet = sc.nextInt();
			
			int[] c1 = new int[planet];
			int[] c2 = new int[planet];
			int[] r = new int[planet];
			
			for(int k=0; k<planet; k++) {
				c1[k] = sc.nextInt();
				c2[k] = sc.nextInt();
				r[k] = sc.nextInt();
				
			}
			for(int t =0; t<planet; t++) {
			if((x1-c1[t])*(x1-c1[t])+(y1-c2[t])*(y1-c2[t])<r[t]*r[t] && (x2-c1[t])*(x2-c1[t])+(y2-c2[t])*(y2-c2[t])>r[t]*r[t]) {
				num++;
			}
			else if((x2-c1[t])*(x2-c1[t])+(y2-c2[t])*(y2-c2[t])<r[t]*r[t] && (x1-c1[t])*(x1-c1[t])+(y1-c2[t])*(y1-c2[t])>r[t]*r[t]) {
				num++;
			}
			else {
				
			}
				
	 	}
			num1[i] = num;
		}
		for(int h=0; h<testcase; h++) {
			System.out.println(num1[h]);
		}
		
		sc.close();
   }

}
