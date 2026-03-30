import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr = new int[1001];
    static int[] dp = new int[1001];

    public static void main(String[] args) {
        Arrays.fill(dp, 1);
        N = Integer.parseInt(readLine());
        var st = new StringTokenizer(readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int longest = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    longest = Math.max(longest, dp[i]);
                }
            }
        }

        System.out.println(longest);
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
