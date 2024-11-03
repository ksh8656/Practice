package CodingTest6;

import java.util.Scanner;

public class Sequence {
	static int number;
	static int[] array;
	static int[] res;

	static public void arr() {
		int t = 0;
		for (int i = 0; i < number - 1; i++) {
			if (array[i] > array[i + 1]) {
				t = array[i];
				array[i] = array[i + 1];
				array[i + 1] = t;
			}
		}
		number--;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		number = sc.nextInt();
		int result = number;

		array = new int[number];
		res = new int[number];

		for (int i = 0; i < number; i++) {
			array[i] = sc.nextInt();
			res[i] = array[i];
		}

		for (int i = 0; i < result - 1; i++) {
			arr();
		}

		for (int i = 0; i < result; i++) {
			for (int k = 0; k < result; k++) {
				if (res[i] == array[k]) {
					System.out.print(k + " ");
					array[k] = -1;
					break;

				}
				
			}
		}
		sc.close();

	}

}
