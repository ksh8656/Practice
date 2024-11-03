package CodingTest4;

import java.util.Scanner;

public class Bridge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		int[] n = new int[testcase];
		int[] m = new int[testcase];
		long[] result = new long[testcase];
		
		for(int i=0; i<testcase; i++) {
			m[i] = sc.nextInt();
			n[i] = sc.nextInt();
		}
		
		for(int t=0; t<testcase; t++) {
			result[t] = Bridgehelp.Combination(n[t],m[t]);
			System.out.println(result[t]);
		}
		
		sc.close();
	}

}
