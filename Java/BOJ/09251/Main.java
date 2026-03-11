import java.io.*;
import java.util.*;

public class Main {

    static char[] s1;
    static char[] s2;
    static int[][] dp;

    public static void main(String[] args) {
        setup();

        System.out.println(solve());
    }

    static void setup() {
        s1 = readLine().toCharArray();
        s2 = readLine().toCharArray();
        dp = new int[s1.length+1][s2.length+1];
    }

    static int solve() {
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i-1] == s2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[s1.length][s2.length];
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
