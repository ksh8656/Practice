package CodingTest16;

import java.util.*;

public class DfsBfs {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // Number of vertices
        int m = sc.nextInt();  // Number of edges
        int v = sc.nextInt();  // Starting vertex number

        // Initialize graph
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Input edge information and build undirected graph
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(w);
            graph[w].add(u);
        }

        // Sort each adjacency list to visit nodes in ascending order
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        // Perform DFS
        visited = new boolean[n + 1];
        StringBuilder dfsResult = new StringBuilder();
        dfs(v, dfsResult);
        System.out.println(dfsResult);

        // Perform BFS
        visited = new boolean[n + 1];
        StringBuilder bfsResult = bfs(v);
        System.out.println(bfsResult);
    }

    // Optimized DFS method (recursive)
    private static void dfs(int node, StringBuilder result) {
        visited[node] = true;
        result.append(node).append(" ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, result);
            }
        }
    }

    // Optimized BFS method
    private static StringBuilder bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.append(node).append(" ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        return result;
    }
}
