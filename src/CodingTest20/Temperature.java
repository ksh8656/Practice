package CodingTest20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Temperature {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] temp = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		for(int i=0; i<m; i++) {
			sum += temp[i];
		}
		int max = sum;
		int k = n - m;
		for(int i=0; i<k; i++) {
			sum = sum - temp[i] + temp[i+m];
			if(max<sum)
				max = sum;
		}
		System.out.println(max);
	}

}
