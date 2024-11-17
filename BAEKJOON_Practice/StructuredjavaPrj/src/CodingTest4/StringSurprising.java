package CodingTest4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class StringSurprising {

	public static boolean isSurprising(String input) {
		int d = input.length();
		for(int i=1; i<d; i++) {
			HashSet<String> sur = new HashSet<>();
			for(int j=0; j<d-i; j++) {
				String pair = "" + input.charAt(j) + input.charAt(j+i);
				if(!sur.add(pair))
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// 문자열을 입력받는다 *가 입력될 때까지
		// 해당 문자열이 is surprising인지 is not인지 확인한다.
		// 문자열 길이가 4면 최대간격이 2이다.
		// 간격이0부터 2까지 중에 중복인 문자열이 존재하면 not을 반환한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String input = br.readLine();
			if (input.equals("*"))
				break;
			else {
				if(isSurprising(input)) {
					sb.append(input+ " is surprising.").append("\n");
				}
				else
					sb.append(input + " is not surprising.").append("\n");					
			}
		}
		
		System.out.println(sb.toString());
	}
}
