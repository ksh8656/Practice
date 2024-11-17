package CodingTest3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FoodWaste {
	// 행, 열, 음식물 쓰레기 개숫 입력을 간격을 두어 받는다.
	// 음식물 쓰레기 위치를 입력받는다. 1~n행, 1~m열
	// 음식물이 모여있는곳의 최대값을 출력한다.
	static int n;
	static int m;
	static int food;
	static int[][] map;
	static boolean[][] visited;
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };
	static int count = 0;

	public static void dfs(int dx, int dy) {
		for (int i = 0; i < 4; i++) {
			int xx = dx + x[i];
			int yy = dy + y[i];
			
			if(xx>=0 && yy>=0 && xx<n && yy<m && !visited[xx][yy] && map[xx][yy] != 0) {
				visited[xx][yy] = true;
				count++;
				dfs(xx,yy);
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		food = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < food; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row - 1][col - 1] = 1;
		}
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					count++;
					dfs(i, j);
				}
				result = Math.max(result, count);
				count = 0;
			}
		}
		
		System.out.println(result);
	}

}
