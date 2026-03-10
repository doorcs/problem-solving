import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static long[][] dp; // `dp[i][j]`는 길이가 i일 때 j로 끝나는 계단 수

    public static void main(String[] args) throws IOException {
        setup();

        System.out.println(solve());
    }

    static void setup() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[101][10];
        for (int i = 1; i <= 9; i++) dp[1][i] = 1; // 길이가 1일 때 0으로 끝나는 계단 수는 없다 ( dp[1][0] = 0 )
    }

    static long solve() {
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1_000_000_000;
            }
            dp[i][0] = (dp[i-1][1]);
            dp[i][9] = (dp[i-1][8]);
        }

        long ans = 0;
        for (long it : dp[N]) ans += it;
        return ans%1_000_000_000;
    }
}
