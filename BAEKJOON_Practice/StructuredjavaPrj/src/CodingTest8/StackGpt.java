package CodingTest8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackGpt {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<Integer> arr = new LinkedList<>();

        int[] target = new int[n];

        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        Stack<Integer> stack = new Stack<>();

        // 입력된 목표 수열
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0; // target 배열의 인덱스를 추적
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+").append("\n");

            // 스택의 최상단 값이 목표 값과 같으면 pop
            while (!stack.isEmpty() && stack.peek() == target[idx]) {
                stack.pop();
                sb.append("-").append("\n");
                idx++;
            }
        }

        // 목표 배열을 만족시키지 못하는 경우
        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
