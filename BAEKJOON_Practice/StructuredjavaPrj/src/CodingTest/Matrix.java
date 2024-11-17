package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Matrix {
	static int n;
	static int m;
	static int[][] a;
	static int[][] b;

	public static void solution(int startY, int startX) {
		for (int i = startY; i < startY + 3; i++) {
			for (int j = startX; j < startX + 3; j++) {
				if (b[i][j] == 0)
					b[i][j]++;
				else
					b[i][j]--;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// N과 M을 띄어쓰기로 입력받아 N*M행렬을 만든다.
		// N*M크기의 A,B행렬을 0과1로 크기만큼 입력 받는다.
		// 시작점을 0,0으로 설정 둘이 다를경우 시작점을 기준으로 3*3에 위치한 값 반대로 출력 그렇게 시작점을 처음부터 끝까지 돌림
		// 시작점이 A랑 Q가 다를 때 마다 카운트하면 됨
		// 3개가 다 다를경우 COUNT+1, 그게 아닐경우 -1 출려ㄱ
		// 예외 N,M이 3보다 작을경우 -1출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new int[n][m];
		b = new int[n][m];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			String input2 = br.readLine();
			for (int j = 0; j < m; j++) {
				b[i][j] = input2.charAt(j) - '0';
			}
		}
		
		int count = 0;
		for (int i = 0; i <= n - 3; i++) {
			for (int j = 0; j <= m - 3; j++) {
				if (a[i][j] != b[i][j]) {
					solution(i, j);
					count++;
				}
			}
		}
		if(!Arrays.deepEquals(a, b))
			count = -1;
		
		System.out.println(count);
	}

}
