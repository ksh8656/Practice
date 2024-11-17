package CodingTest5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class State2 {
	int[] arr;
	int count;

	State2(int[] arr, int count) {
		this.arr = arr;
		this.count = count;
	}
}

public class SortGame2 {

	public static void main(String[] args) throws IOException {
		// 첫째 줄에 n과 k를 간격을 두어 입력 받는다.
		// 둘째 줄에 n크기의 배열 arr을 입력받는다.
		// 배열 arr을 복제 후 오름차순 시켜서 target 배열을 만든다.
		// bfs함수를 통해 arr이 target이 되는 최소 횟수를 구한다.
		// reverse함수를 통해 k크기만큼 뒤집는다.
		// queue에 들어갈 클래스를 생성한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] target = arr.clone();
		Arrays.sort(target);

		System.out.println(bfs(arr, target, k));
	}

	public static int bfs(int[] arr, int[] target, int k) {
		Queue<State2> queue = new LinkedList<>();
		HashSet<String> set = new HashSet<>();
		queue.add(new State2(arr, 0));
		set.add(Arrays.toString(arr));

		while (!queue.isEmpty()) {
			State2 current = queue.poll();

			if (Arrays.equals(current.arr, target))
				return current.count;

			for (int i = 0; i <= current.arr.length - k; i++) {
				int[] nextarr = current.arr.clone();
				reverse(nextarr, i, i + k - 1);
				String next = Arrays.toString(nextarr);

				if (!set.contains(next)) {
					queue.add(new State2(nextarr, current.count + 1));
					set.add(next);
				}

			}

		}
		return -1;
	}

	public static void reverse(int[] nextarr, int start, int end) {
		while (start < end) {
			int temp = nextarr[start];
			nextarr[start] = nextarr[end];
			nextarr[end] = temp;
			start++;
			end--;
		}
	}

}
