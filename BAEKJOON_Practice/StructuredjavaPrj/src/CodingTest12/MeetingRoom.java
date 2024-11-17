package CodingTest12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MeetingRoom {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String test = br.readLine();
		int n = Integer.parseInt(test);
		int[][] arr = new int[n][2];
		int[][] remember = new int[n][2];

		int[] arrsize = new int[n];
		int[] time = new int[n];

		for (int i = 0; i < n; i++) {
			String tim = br.readLine();
			String[] part = tim.split(" ");

			remember[i][0] = Integer.parseInt(part[0]);
			remember[i][1] = Integer.parseInt(part[1]);
			arrsize[i] = remember[i][1];

			arr[i][0] = (Integer.parseInt(part[1]) - Integer.parseInt(part[0]));
			arr[i][1] = i;
			time[i] = arr[i][0];
		}
		Arrays.sort(arrsize);
		Arrays.sort(time);

		int[] result = new int[arrsize[n - 1] + 1];
		int count = 0;// 결과값 변수

		Set<Integer> set = new HashSet<>();
		for (int t : time) {
			set.add(t);
		}

		// Set을 배열로 변환
		int[] hive = new int[set.size()];
		int index = 0;
		for (int t : set) {
			hive[index++] = t;
		}

		for (int min : hive) {
			for (int i = 0; i < n; i++) {
				if (min == arr[i][0]) {
					boolean canAllocate = true;
					for (int k = result[remember[i][0] + 1]; k < result[remember[i][1]]; k++) {
						if (result[k] != 1) {
							canAllocate = false;
							break;
						}
					}
					if(canAllocate) {
						   for (int t = remember[i][0] + 1; t < remember[i][1]; t++) {
	                            result[t] = 1;
	                        }
	                        count++;
					}

				}

			}

		}
		System.out.println(count);

	}
}
