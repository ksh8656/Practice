package CodingTest24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GptFriedCount {
    static int n;
    static ArrayList<Character>[] yesorno;
    static boolean[] visited;
    static int count = 0;

    // 친구 수를 세는 함수 수정
    public static void friendcount(int person) {
        for (int j = 0; j < n; j++) {
            // 친구이고 아직 방문하지 않은 경우
            if ('Y' == yesorno[person].get(j) && !visited[j]) {
                count++;
                visited[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        yesorno = new ArrayList[n];
        int result = 0;

        // 입력을 받아 yesorno 배열에 각 사람의 친구 정보를 저장.
        for (int i = 0; i < n; i++) {
            yesorno[i] = new ArrayList<>();
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                yesorno[i].add(input.charAt(j));
            }
        }

        // 각 사람마다 2-친구를 탐색.
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            count = 0;
            visited[i] = true;

            // 1단계: 직접 친구를 찾는다.
            for (int j = 0; j < n; j++) {
                if ('Y' == yesorno[i].get(j) && !visited[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            // 2단계: 직접 친구의 친구들을 찾는다.
            for (int j = 0; j < n; j++) {
                if ('Y' == yesorno[i].get(j)) { // 직접 친구인 경우만 탐색
                    friendcount(j); // 간접 친구 탐색
                }
            }

            // 최대 2-친구 수를 result에 업데이트.
            if (count > result)
                result = count;
        }

        // 결과 출력: 가장 많은 2-친구 수.
        System.out.println(result);
    }
}