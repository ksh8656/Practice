package CodingTest6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Number_two {
	public static HashSet<List<Integer>> hash = new HashSet<>(); // 클래스 변수로 이동하여 모든 호출에서 공유되도록 함

	public static void main(String[] args) throws IOException {
		// 이진수의 자리수인 n을 입력 받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int count = 0;
		List<Integer> list = new ArrayList<>();
		list.add(1);

		System.out.println(generateArr(list, n, count));
	}

	public static int generateArr(List<Integer> list, int length, int count) {
		List<Integer> copyList = new ArrayList<>(list);
		
		while (!(list.size() == length)) {
            // 리스트를 복제하여 저장
            if (!hash.contains(copyList)) {
                count++;
                hash.add(copyList);
            }
            
        }

        if (list.get(list.size() - 1) == 1) {
            list.add(0);
            generateArr(list, length,count);
            list.remove(list.size() - 1); // 백트래킹을 위해 마지막 요소 제거
        }

        else if (list.get(list.size() - 1) == 0) {
            list.add(0);
            generateArr(list, length,count);
            list.remove(list.size() - 1); // 백트래킹을 위해 마지막 요소 제거
        

            if(list.get(list.size() - 1) == 0) 
            list.add(1);
            generateArr(list, length,count);
            list.remove(list.size() - 1); // 백트래킹을 위해 마지막 요소 제거
        }
        
        return count;
    }
}
