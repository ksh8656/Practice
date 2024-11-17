package CodingTest24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CountFriend {
	static boolean[] visited;
	static ArrayList<Character>[] yorn;

	public static int friendcount(int person, int number, int count) {
		for (int i = 0; i < number; i++) {
			if (yorn[person].get(i) == 'Y' && !visited[i]) {
				count++;
				visited[i] = true;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		yorn = new ArrayList[n];
		int count = 0;
		int result = 0;
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			yorn[i] = new ArrayList<>();
			for(int j=0; j<n; j++) {
				yorn[i].add(input.charAt(j));
			}
		}
		for(int i=0; i<n; i++) {
			visited = new boolean[n];
			visited[i] = true;
			count = 0;
			for(int j=0; j<n; j++) {
				if('Y' == yorn[i].get(j)) {
					count++;
					visited[j] = true;
				}
			}
			for(int a=0; a<n; a++) {
				if('Y' == yorn[i].get(a) && a!=i) {
					count = friendcount(a,n,count);
				}
			}
		 	result = Math.max(result, count);
		}
		
		System.out.println(result);
	}

}
