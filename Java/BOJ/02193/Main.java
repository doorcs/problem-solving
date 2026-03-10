import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static long[][] dp; // `int[][] dp` 쓰면 틀린다!!

    public static void main(String[] args) throws IOException {
        setup();
        solve();

        System.out.println(dp[N][0] + dp[N][1]);
    }

    static void setup() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][2];
        dp[1][1] = 1;
    }

    static void solve() {
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
    }
}

// 첫 풀이 (리팩토링 전)

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static int N;
//     static long[][] dp;

//     public static void main(String[] args) throws IOException {
//         N = Integer.parseInt(br.readLine());
//         dp = new long[N+1][2];
//         dp[1][1] = 1;

//         for (int i = 2; i <= N; i++) {
//             dp[i][0] = dp[i-1][0] + dp[i-1][1];
//             dp[i][1] = dp[i-1][0];
//         }

//         System.out.println(dp[N][0] + dp[N][1]);
//     }
// }
