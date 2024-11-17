package CodingTest22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hap {

    int n, m, result;
    int[] number;
    
    public void backtrack(int idx, int sum, boolean included) {
        if (idx == n) { // 모든 요소를 다 탐색한 경우
            if (sum == m && included) {
                result++;
            }
            return;
        }

        // 현재 인덱스의 값을 포함하지 않는 경우
        backtrack(idx + 1, sum, included);

        // 현재 인덱스의 값을 포함하는 경우
        backtrack(idx + 1, sum + number[idx], true);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Hap hap = new Hap();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        hap.n = Integer.parseInt(st.nextToken());
        hap.m = Integer.parseInt(st.nextToken());
        hap.result = 0;

        st = new StringTokenizer(br.readLine());
        hap.number = new int[hap.n];

        for (int i = 0; i < hap.n; i++) {
            hap.number[i] = Integer.parseInt(st.nextToken());
        }

        // 백트래킹으로 부분 수열의 합이 m이 되는 경우의 수 찾기
        hap.backtrack(0, 0, false);

        System.out.println(hap.result);
    }

}
