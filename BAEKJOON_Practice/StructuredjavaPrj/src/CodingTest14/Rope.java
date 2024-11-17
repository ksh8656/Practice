package CodingTest14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rope {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int k = 0;
		int[] input = new int[n];
		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(input);

		for (int i = n; i > 0; i--) {
			while (k < n) {
				result[k] = input[k] * i;
				k++;
				break;
			}
		}

		Arrays.sort(result);

		System.out.println(result[n - 1]);

		br.close();

	}

}
