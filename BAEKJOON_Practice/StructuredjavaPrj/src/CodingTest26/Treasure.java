package CodingTest26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Treasure {

	public static void main(String[] args) throws IOException{
		// n을 입력받는다
		// a배열과 b배열을 입력 받는다.
		// a배열을 내림차순으로 정렬하고 b배열의 원래 위치를 기억한 뒤
		// a[i]*b[i]의 최소값을 찾는다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] a = new Integer[n];
		Integer[] b = new Integer[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st =  new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		Arrays.sort(b,Collections.reverseOrder());
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum+=a[i]*b[i];
		}
		
		System.out.println(sum);
		
	}

}
