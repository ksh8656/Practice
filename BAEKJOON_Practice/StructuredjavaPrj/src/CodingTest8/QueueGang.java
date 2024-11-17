package CodingTest8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class QueueGang {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());

			if (num[i] == 0) {
				if (queue.isEmpty()) {
					sb.append("0").append("\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
			} else {
				queue.add(num[i]);
			}
		}

		System.out.println(sb);

	}

}
