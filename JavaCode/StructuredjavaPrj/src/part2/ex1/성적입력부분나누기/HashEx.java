package part2.ex1.성적입력부분나누기;

import java.io.*;
import java.util.*;


public class HashEx {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int a = 0; a < n; a++) {
			arr[a][0] = Integer.parseInt(st.nextToken());
			arr[a][1] = a;
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});
		int max = 0;
		for(int i=0; i<n; i++) {
			if(max<arr[i][1] - i) {
				max = arr[i][1] - i;
			}
		}
		
		System.out.println(max);

	}

}
