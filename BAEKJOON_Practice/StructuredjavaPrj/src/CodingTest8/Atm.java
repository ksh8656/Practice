package CodingTest8;

import java.util.Arrays;
import java.util.Scanner;

public class Atm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int num = 0;
		int result = 0;
		int[] array = new int[people];

		for (int i = 0; i < people; i++) {
			array[i] = sc.nextInt();
		}

		Arrays.sort(array);

		for (int i = 0; i < people; i++) {
			num += array[i];
			result+=num;
		}

		
		System.out.println(result);

		sc.close();

	}

}
