package CodingTest8;

import java.util.Arrays;
import java.util.Scanner;

public class GptCode8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int result = 0;
        int sum = 0;
        int[] array = new int[people];

        for (int i = 0; i < people; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        for (int time : array) {
            sum += time;
            result += sum;
        }

        System.out.println(result);

        sc.close();
    }
}