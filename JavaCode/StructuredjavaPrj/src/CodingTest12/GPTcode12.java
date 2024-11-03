package CodingTest12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GPTcode12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 회의의 개수 입력받기
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];

        // 각 회의의 시작 시간과 끝나는 시간을 입력받아 배열에 저장
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(input[0]); // 시작 시간
            meetings[i][1] = Integer.parseInt(input[1]); // 끝나는 시간
        }

        // 끝나는 시간을 기준으로 정렬 (버블 정렬 사용)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // 끝나는 시간을 기준으로 정렬, 끝나는 시간이 같으면 시작 시간을 기준으로 정렬
                if (meetings[j][1] > meetings[j + 1][1] || (meetings[j][1] == meetings[j + 1][1] && meetings[j][0] > meetings[j + 1][0])) {
                    int[] temp = meetings[j];
                    meetings[j] = meetings[j + 1];
                    meetings[j + 1] = temp;
                }
            }
        }

        int count = 0; // 최대 회의 개수를 저장할 변수
        int endTime = 0; // 현재 회의의 끝나는 시간을 저장할 변수

        // 회의실 사용 가능한 최대 개수 찾기
        for (int i = 0; i < n; i++) {
            // 현재 회의의 시작 시간이 이전 회의의 끝나는 시간 이후인 경우 회의 선택
            if (meetings[i][0] >= endTime) {
                endTime = meetings[i][1]; // 회의 종료 시간 갱신
                count++; // 회의 개수 증가
            }
        }

        // 최대 사용할 수 있는 회의 개수 출력
        System.out.println(count);
    }
}
