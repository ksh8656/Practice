package CodingTest25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessPaint {
	static char[][] ch;
	
	public static int solution(int n, int m,int count) {
		char[][] white = {{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}};
		int roop = 0;
		for(int i=n; i<n+8; i++) {
			for(int j=m; j<m+8; j++) {
				if(ch[i][j] != white[roop][j-m]) {
					count++;
				}
			}
			roop = (roop+1) % 2;
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		// n*m입력받기
		// 보드판색 입력받기 w흰색b검정색
		// 8*8크기이므로 시작점을 0부터 n-8행과 0부터 m-8열까지 시작점 형성
		//white로 판으로 만들 때 칠해야 하는 개수, n*m-white = black판으로 만들때 칠해야 하는 개수
		// 다시 칠해야 하는 보드판의 개수의 최솟값 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ch = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				ch[i][j] = input.charAt(j);
			}
		}
		
		int count=0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				count = 0;
				count = solution(i,j,count);
				if(min>Math.min(count, 64-count)) {
					min = Math.min(count, 64-count);
				}
			}
		}
		
		System.out.println(min);

	}

}
