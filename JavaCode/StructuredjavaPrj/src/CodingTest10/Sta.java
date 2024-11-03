package CodingTest10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sta {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String testcase = br.readLine();
		int test = Integer.parseInt(testcase);
		int[] res = new int[test];
		int[] stack = new int[test];
		int tep = -1;
		int re = 0;
		

		for (int i = 0; i < test; i++) {
			String input = br.readLine();
			String[] part = input.split(" ");

			switch (part[0]) {
			case "push":
				stack[++tep] = Integer.parseInt(part[1]);
				break;
			case "pop":
				if(tep >= 0)
				res[re++] = stack[tep--];
				else
					res[re++] = -1;
				re++;
				break;
			case "size":
				res[re++] = tep+1;
				re++;
				break;
			case "empty":
				if(tep > -1)
					res[re++] = 0;
				else
					res[re++] = 1;
				re++;
				break;
			case "top":
				if(tep == -1) 
					res[re++] = -1;
				else
					res[re++] = stack[tep];
				re++;
				break;			
			}
		}
		for(int i=0; i<re; i++) {
			System.out.println(res[i]);
		}
		br.close();

	}

}
