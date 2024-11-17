package CodingTest12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int meet = Integer.parseInt(br.readLine());
		int[][] array = new int[meet][2];

		for (int i = 0; i < meet; i++) {
			String part = br.readLine();
			String[] part1 = part.split(" ");

			array[i][0] = Integer.parseInt(part1[0]);
			array[i][1] = Integer.parseInt(part1[1]);
		}

		Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[1] == b[1])
					return Integer.compare(a[0], b[0]);
				else
					return Integer.compare(a[1], b[1]);
			}
		});
		
		int start = 0;
		int count = 0;
		for(int i=0; i<meet; i++) {
			if(array[i][0]>=start) {
				start = array[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}

}
