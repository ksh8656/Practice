package CodingTest21;

import java.util.*;
import java.io.*;

public class Tree {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int result = 0;
		int[][] array = new int[n][m];

		for (int j = 0; j < n; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				array[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int fin = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int start2 = Integer.parseInt(st.nextToken());
		int fin2 = Integer.parseInt(st.nextToken());
	
		for(int i=start-1; i<fin; i++) {
			for(int j=0; j<m; j++) {
				if(array[i][j] == 1) {
					array[i][j] = 0;
					break;
				}
			}
		}
		
		for(int i=start2-1; i<fin2; i++) {
			for(int j=0; j<m; j++) {
				if(array[i][j] == 1) {
					array[i][j] = 0;
					break;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(array[i][j] == 1)
					result++;
			}
		}
		
		System.out.println(result);
	}
	

}
