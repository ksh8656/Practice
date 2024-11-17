package CodingTest15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Station {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int city = Integer.parseInt(br.readLine());
		int[] fuelarr = new int[city]; // 도시의 기름값 배열 생성
		int[] disarray = new int[city - 1]; // 거리 배열 생성
		

		StringTokenizer stt = new StringTokenizer(br.readLine()); //거리 배열 거리값 대입

		for (int i = 0; i < city - 1; i++) {
			disarray[i] = Integer.parseInt(stt.nextToken());
		}

		StringTokenizer st = new StringTokenizer(br.readLine()); //도시 배열 기름값 대입

		for (int i = 0; i < city; i++) {
			fuelarr[i] = Integer.parseInt(st.nextToken());
		}
		
		int minfuel = fuelarr[0];
		long cost = 0;
		
		for(int i=0; i<city-1; i++) {
			if(minfuel>fuelarr[i]) 
				minfuel = fuelarr[i];
			
				cost = cost + (long) disarray[i] * minfuel;				
		}
		
		System.out.println(cost);


	}

}
