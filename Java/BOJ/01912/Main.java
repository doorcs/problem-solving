import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        setup();
        System.out.println(solve());
    }

    static void setup() throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        var st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int solve() {
        int ans = dp[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1] + dp[i], dp[i]);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
