package CodingTest22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GptHap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;

        st = new StringTokenizer(br.readLine());
        int[] number = new int[n];

        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        // 모든 부분 수열의 합을 찾기 위한 로직 수정
        for (int i = 0; i < n; i++) {
            sum = number[i];
            if (sum == m) {
                result++;
            }
            for (int j = i + 1; j < n; j++) {
                sum += number[j];
                if (sum == m) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
