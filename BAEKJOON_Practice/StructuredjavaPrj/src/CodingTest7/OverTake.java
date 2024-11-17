package CodingTest7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class OverTake {

	public static void main(String[] args) throws IOException {
		//터널을 지나가는 자동차 개수n을 입력받는다.
		//HashMap을 만들고 터널을 들어오는 순서대로 value를 1부터 시작해서 부여한다.
		//n+2번째 줄을 x로 정의하고 x부터 입력받은 값의 value을 current에 집어 넣는다.
		//x이후의 value값 중 current보다 큰 값이 있으면 result++한다.
		//result를 출력한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> tunel = new HashMap<>();
		for(int i=1; i<=n; i++) {
			tunel.put(br.readLine(), i);
		}
		
		int[] current = new int[n];
		for(int i = 0; i<n; i++) {
			String input = br.readLine();
			current[i] = tunel.get(input);			
		}
		
		int result = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(current[i]>current[j]) {
					result++;
					break;
				}
			}
		}
		System.out.println(result);

	
	}

}
