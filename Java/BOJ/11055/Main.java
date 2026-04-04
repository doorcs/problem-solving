import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr = new int[1001];
    static long[] dp = new long[1001];

    public static void main(String[] args) {
        N = Integer.parseInt(readLine());
        var st = new StringTokenizer(readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;

        for (int i = 1; i <= N; i++) {
            dp[i] = arr[i];
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
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
