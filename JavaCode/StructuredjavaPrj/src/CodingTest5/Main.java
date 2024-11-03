package CodingTest5;

import java.util.Scanner;

public class Main {
    // 상하좌우 이동을 위한 좌표 변화량
    static int[] dx = {0, 0, -1, 1}; // 좌, 우, 상, 하
    static int[] dy = {-1, 1, 0, 0}; // 좌, 우, 상, 하
    static int[][] field; // 배추밭
    static boolean[][] visited; // 방문 여부
    static int n, m; // 밭의 크기 (n: 세로, m: 가로)

    // DFS로 연결된 배추를 모두 방문 처리
    public static void dfs(int x, int y) {
        visited[x][y] = true;

        // 상하좌우로 이동하며 인접한 배추가 있는지 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 내에 있고 배추가 있으며 방문하지 않은 곳이라면 탐색
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && field[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // 테스트 케이스 개수

        // 여러 테스트 케이스 처리
        for (int tc = 0; tc < t; tc++) {
            m = sc.nextInt(); // 밭의 가로 길이
            n = sc.nextInt(); // 밭의 세로 길이
            int k = sc.nextInt(); // 배추가 심어진 위치의 개수

            field = new int[n][m];
            visited = new boolean[n][m];

            // 배추 위치 입력 받기
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt(); // 배추의 x좌표 (가로)
                int y = sc.nextInt(); // 배추의 y좌표 (세로)
                field[y][x] = 1;
            }

            int wormCount = 0; // 필요한 지렁이 수

            // 모든 배추밭을 순회하며 지렁이가 필요한 배추 그룹 찾기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 배추가 있고 아직 방문하지 않았다면 새로운 그룹 발견
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        wormCount++; // 새로운 그룹이 발견될 때마다 지렁이 추가
                    }
                }
            }

            // 각 테스트 케이스마다 결과 출력
            System.out.println(wormCount);
        }

        sc.close();
    }
}