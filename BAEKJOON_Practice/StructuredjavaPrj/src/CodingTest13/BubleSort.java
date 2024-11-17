package CodingTest13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubleSort {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int flag,i;
		int[] array = new int[n];
		
		for(int t = 0; t<n; t++) 
			array[t] = Integer.parseInt(br.readLine());
		
		for(i=0; i<n; i++) {
			flag = 0;
			for(int j=0; j<n-1; j++) {
				if(array[j]>array[j+1]) {
					flag = 1;
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
				
			}
			if(flag == 0)
				break;
			
		}
		System.out.println(i);
		br.close();
	}

}
