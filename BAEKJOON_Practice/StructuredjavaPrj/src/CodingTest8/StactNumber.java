package CodingTest8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StactNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int[] target = new int[n];
		for (int i = 0; i < n; i++) {
			target[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<>();
		int num = 1; // 현재 스택에 넣을 숫자
		boolean isPossible = true;
		
		for(int i=0; i<n; i++) {
			int current = target[i];
			
			while(num<=current) {
				stack.push(num++);
				sb.append("+").append("\n");
			}
			
			if(!stack.isEmpty() && current == stack.peek()) {
				stack.pop();
				sb.append("-").append("\n");
			}
			else {
				isPossible = false;
			}
			
		}
		if(isPossible)
			System.out.println(sb);
		else
			System.out.println("NO");
	}
}