package CodingTest5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class State{
	int[] arr;
	int depth;

	State(int[] arr, int depth) {
		this.arr = arr;
		this.depth = depth;
	}
}

public class SortGame {

	public static void main(String[] args) throws IOException {
		// N과 K를 간격을 두어 입력 받는다.
		// N배열을 간격을 두어 입력 받는다.
		// 현재 배열을 입력받는 클래스 생성
		// bfs함수를 이용하여 생성하여 정렬되는데 최솟값 반환
		// 특정 구간 배열을 바꾸는 reserve함수 생성
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
		Queue<State> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		queue.add(new State(arr,0));
		visited.add(Arrays.toString(arr));
		
		while(!queue.isEmpty()) {
			State current = queue.poll();
			
			if(Arrays.equals(current.arr, target)) {
				return current.depth;
			}
			
			for(int i=0; i<=current.arr.length-k; i++) {
				int[] nextarr = current.arr.clone();
				reserve(nextarr, i, i+k-1);
				String next = Arrays.toString(nextarr);
				
				if(!visited.contains(next)) {
					queue.add(new State(nextarr,current.depth + 1));
					visited.add(next);
				}
			}
		}
		return -1;
	}
	
	public static void reserve(int[] nextarr, int start, int end) {
		while(start<end) {
			int temp = nextarr[start];
			nextarr[start] = nextarr[end];
			nextarr[end] = temp;
			start++;
			end--;
		}
	}

}
