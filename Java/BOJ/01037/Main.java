import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int cnt = Integer.parseInt(readLine());
        var st = new StringTokenizer(readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < cnt; i++) {
            int curr = Integer.parseInt(st.nextToken());
            min = Math.min(min, curr);
            max = Math.max(max, curr);
        }

        System.out.println(min*max);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
