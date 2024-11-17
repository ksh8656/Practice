package CodingTest11;

import java.util.Scanner;

public class Q {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n; // 입력값 개수 변수
		n = sc.nextInt();
		sc.nextLine();

		int num = 0; // push하는 정수를 기억할 변수
		int index = -1; // 큐의 인덱스 위치를 기억할 변수

		String[] que = new String[n]; // 입력값을 넣을 배열
		int[] result = new int[n]; // 결과를 저장할 배열

		for (int i = 0; i < n; i++) {
			que[i] = sc.nextLine();
			String part[] = que[i].split(" ");

			switch (part[0]) {
			case "push":
				num = Integer.parseInt(part[1]);
				result[++index] = num;
				break;
			case "pop":
				for (int t = 0; t <= index; t++) {
					if (result[t] != 0) {
						System.out.println(result[t]);
						result[t] = 0;
						break;
					}
					else if(result[index]== 0) {
						System.out.println(-1);
						break;
					}

				}
				if (index == -1) {
					System.out.println(-1);
				}
				break;
			case "size":
				int count = 0;
				for (int t = 0; t <= index; t++) {
					if (result[t] != 0)
						count++;
				}
				System.out.println(count);
				break;
			case "empty":
				for (int t = 0; t <= index; t++) {
					if (result[t] != 0) {
						System.out.println(0);
						break;
					} else if(result[index] == 0) {
						System.out.println(1);
						break;
					}			
				}
				if(index == -1)
					System.out.println(1);
				break;
			case "front":
				for (int t = 0; t <= index; t++) {
					if (result[t] != 0) {
						System.out.println(result[t]);
						break;
					} else if (result[index] == 0 && index != -1) {
						System.out.println(-1);
						break;
					}
				}
				if (index == -1) {
					System.out.println(-1);
				}
				break;
			case "back":
				if (index == -1 || result[index] == 0) {
					System.out.println(-1);
				} else
					System.out.println(result[index]);
				break;

			}
		}
	}

}
