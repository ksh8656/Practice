package CodingTest18;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
	static int N;
	static int M;
	static int[][] maze;
	static boolean[][] visited;
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();

		maze = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(bfs(0,0));
	}

	public static int bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {a,b});
		visited[a][b] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int xx = current[0];
			int yy = current[1];
			
			for(int i=0; i<4; i++) {
				int nextx = xx + x[i];
				int nexty = yy + y[i];
				
				if(nextx>=0 && nexty>=0 && nextx<N && nexty<M && !visited[nextx][nexty] && maze[nextx][nexty] == 1) {
					maze[nextx][nexty] = maze[xx][yy] + 1;
					visited[nextx][nexty] = true;
					queue.add(new int[] {nextx,nexty});
				}
			}
		}
		
		return maze[N-1][M-1];
	}
}
