package CodingTest5;

import java.util.Scanner;

public class Cabbage {

    static int[] xx = {0, 0, -1, 1};
    static int[] yy = {1, -1, 0, 0};
    static int[][] farm;
    static int[] warm;
    static boolean[][] visited;
    static int x;
    static int y;

    public static void dfs(int n, int m) {
        visited[n][m] = true;
        for (int c = 0; c < 4; c++) {
            int nxx = n + xx[c];
            int nyy = m + yy[c];

            if (nxx >= 0 && nyy >= 0 && nxx < x && nyy < y && farm[nxx][nyy] == 1 && !visited[nxx][nyy]) {
                dfs(nxx, nyy);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt(); // 테스트 케이스 경우의 수
        warm = new int[testcase];

        for (int i = 0; i < testcase; i++) {
            y = sc.nextInt(); // 농장 가로
            x = sc.nextInt(); // 농장 세로
            int cab = sc.nextInt(); // 배추 개수

            farm = new int[x][y]; // 농장 설정
            visited = new boolean[x][y];

            for (int k = 0; k < cab; k++) {
                int ny = sc.nextInt();
                int nx = sc.nextInt();

                // 유효성 체크
                if (nx >= 0 && nx < x && ny >= 0 && ny < y) {
                    farm[nx][ny] = 1; // 배추가 있는 곳에 1 대입
                } else {
                    System.out.println("Invalid cabbage position: (" + nx + ", " + ny + ")");
                }
            }

            // 각 배추의 연결된 개체 세기
            for (int a = 0; a < x; a++) {
                for (int b = 0; b < y; b++) {
                    if (farm[a][b] == 1 && !visited[a][b]) {
                        dfs(a, b);
                        warm[i]++;
                    }
                }
            }
        }

        for (int h = 0; h < testcase; h++) {
            System.out.println(warm[h]);
        }

        sc.close();
    }
}
