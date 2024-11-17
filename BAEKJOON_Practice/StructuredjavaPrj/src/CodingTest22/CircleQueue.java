package CodingTest22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CircleQueue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] target;
		int count = 0;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		target = new int[m];

		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			target[i] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < m; i++) {
			int current = target[i];
			int change = 0;

			for (int number : queue) {
				if (current == number)
					break;
				change++;
			}

			int half = queue.size() / 2;
			if (change <= half) {
				for (int j = 0; j < change; j++) {
					queue.add(queue.poll());
					count++;
				}
			} else if (change > half) {
				for (int k = 1; k <= queue.size() - change; k++) {
					queue.addFirst(queue.pollLast());
					count++;
				}
			}
			queue.poll();
		}
		System.out.println(count);
	}

}
