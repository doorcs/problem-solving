import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int num = 1;
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(br.readLine());

            while (num <= curr) {
                stk.push(num++);
                sb.append('+').append('\n');
            }

            if (curr == stk.peek()) {
                sb.append('-').append('\n');
                stk.pop();
                continue;
            } else {
                bw.write("NO");
                bw.flush();
                return;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
