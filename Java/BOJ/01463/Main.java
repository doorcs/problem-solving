import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1]+1;
            if (i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if (i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1); // 조건이 여러개라면 갱신 시도를 여러 번 해도 된다
        }

        System.out.println(dp[N]);
    }
}
