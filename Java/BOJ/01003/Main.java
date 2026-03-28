import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int[][] dp = new int[41][2];

    public static void main(String[] args) {
        T = Integer.parseInt(readLine());
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        var sb = new StringBuilder();
        while (T-- > 0) {
            int curr = Integer.parseInt(readLine());
            sb.append(dp[curr][0]).append(' ').append(dp[curr][1]).append('\n');
        }

        System.out.println(sb);
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
