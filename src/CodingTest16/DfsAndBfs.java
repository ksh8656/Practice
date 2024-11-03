package CodingTest16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class DfsAndBfs {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();
		int first = sc.nextInt();

		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		StringBuilder dfsresult = new StringBuilder();
		dfs(first, dfsresult);
		System.out.println(dfsresult);

		visited = new boolean[N + 1];
		StringBuilder bfsresult = new StringBuilder();
		bfs(first, bfsresult);
		System.out.println(bfsresult);

	}

	private static void dfs(int node, StringBuilder result) {
		visited[node] = true;
		result.append(node).append(" ");

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next, result);
			}
		}
	}

	private static void bfs(int node, StringBuilder result) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (!visited[current]) {
				visited[current] = true;
				result.append(current).append(" ");
				for (int next : graph[current]) {
					queue.add(next);
				}
			}
		}

	}

}
