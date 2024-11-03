package CodingTest17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Warm {
	static ArrayList<Integer>[] comarr;
	static int count = 0;
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int computer = sc.nextInt();
		int edge = sc.nextInt();
		
		comarr = new ArrayList[computer+1];
		
		for(int i=0; i<=computer; i++) {
			comarr[i] = new ArrayList<>();			
		}
		
		for(int i=0; i<edge; i++) {
			int a = sc.nextInt();
			int b =sc.nextInt();
			
			comarr[a].add(b);
			comarr[b].add(a);			
		}
		
		for(int i=1; i<computer+1; i++) {
			Collections.sort(comarr[i]);
		}
		visited = new boolean[computer+1];
		dfs(1);
		System.out.println(count);
		
	}
	
	public static void dfs(int a) {
		visited[a] = true;
		for(int next : comarr[a]) {
			if(!visited[next]) {
				count++;
				dfs(next);
			}
		}
	}

}
