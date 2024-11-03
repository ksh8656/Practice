package CodingTest10;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GPTstack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        int[] stack = new int[test];
        int topIndex = -1;

        for (int i = 0; i < test; i++) {
            String input = br.readLine();
            String[] part = input.split(" ");

            switch (part[0]) {
                case "push":
                    stack[++topIndex] = Integer.parseInt(part[1]);
                    break;
                case "pop":
                    if (topIndex >= 0) {
                        bw.write(stack[topIndex--] + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "size":
                    bw.write((topIndex + 1) + "\n");
                    break;
                case "empty":
                    bw.write((topIndex == -1 ? 1 : 0) + "\n");
                    break;
                case "top":
                    if (topIndex == -1) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack[topIndex] + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}