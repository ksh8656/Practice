package CodingTest19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
	static int n; // 열
	static int m; // 행
	static int[][] array;
	static int count = 0;
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		array = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
		bfs();
        
		boolean flag = true;
		for(int[] number : array) {
			for(int num : number) {
				if(num==0) {
					flag = false;
					count = 0;
					break;
				}
			}
			if(!flag)
				break;
		}
		System.out.println(count-1);
	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
        
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (array[i][j] == 1) {
					queue.add(new int[] { i, j });
				}
			}
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
            
			for (int a = 0; a <size; a++) {
				int[] current = queue.poll();
				int xx = current[0];
				int yy = current[1];
                
				for (int k = 0; k < 4; k++) {
					int dx = xx + x[k];
					int dy = yy + y[k];

					if (dx >= 0 && dy >= 0 && dx < m && dy < n && array[dx][dy] == 0) {
						queue.add(new int[] { dx, dy });
                        array[dx][dy] = 1;
					}
				}

			}
			count++;
			
		}

	}

}