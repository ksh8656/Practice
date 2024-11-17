package CodingTest24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FriedCount {
	static int n;
	static ArrayList<Character>[] yesorno;
	static boolean[] visited;
	
	public static int friendcount(int person, int count) {
			for(int j=0; j<n; j++) {
				if('Y' == yesorno[person].get(j) && !visited[j]) {
					visited[j] = true;
					count++;					
				}
			}
			return count;
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		yesorno = new ArrayList[n];
		int result = 0;
		int count = 0;

		for (int i = 0; i < n; i++) {
			yesorno[i] = new ArrayList<>();
			String input = br.readLine();
			for(int j=0; j<n; j++) {
				yesorno[i].add(input.charAt(j));
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			count = 0;
			visited[i] = true;
			for (int j = 0; j < n; j++) {
				if ('Y' == yesorno[i].get(j) && !visited[j]) {
					count++;
					visited[j] = true;
				}
			}
			
			for(int a = 0; a<n; a++) {
				if(visited[a] && a!=i) {
					count = friendcount(a,count);
				}
			}
			if(count>result)
				result = count;
			
		}
		
		System.out.println(result);

	}

}
