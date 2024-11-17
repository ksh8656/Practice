package CodingTest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ComeBackHome {
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static char[][] map;
	static int row;
	static int col;
	static int result = 0;
	static int fal;
	
	public static void dfs(int startR, int startC, int depth) {
		if (startR == 0 && startC == col - 1 && depth == fal) {
			result++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int xx = x[i] + startR;
			int yy = y[i] + startC;

			if (xx >= 0 && yy >= 0 && xx < row && yy < col && !visited[xx][yy] && map[xx][yy] != 'T') {
				visited[xx][yy] = true;
				dfs(xx, yy, depth+1);
				visited[xx][yy] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// R, C, K값을 공백으로 입력 받는다, t위치를 입력 받는다.
		//r-1행 0열에서 시작하여 0행 c-1열까지 걸리는 k거리의 경우의 수를 구한다.
		//재귀함수를 사용하여 거리값에 +1씩 한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		fal = Integer.parseInt(st.nextToken());

		visited = new boolean[row][col];
		map  = new char[row][col];
		
		for(int i=0; i<row; i++) {
			String input = br.readLine();
			for(int j=0; j<col; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		visited[row-1][0] = true;
		dfs(row - 1, 0, 1);

		System.out.println(result);

		br.close();
	}

}
