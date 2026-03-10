import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        setup();
        solve();

        System.out.println(dp[n]);
    }

    static void setup() throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
    }

    static void solve() {
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10_007;
        }
    }
}

// 첫 풀이 (1차원 DP로도 풀 수 있는 문제인데 DP 배열을 2차원으로 씀)

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static int n;
//     static int[][] dp; // [i][0] = 세로블럭, [i][1] = 가로블럭

//     public static void main(String[] args) throws IOException {
//         setup();
//         solve();

//         System.out.println((dp[n][0] + dp[n][1])%10_007);
//     }

//     static void setup() throws IOException {
//         n = Integer.parseInt(br.readLine());
//         dp = new int[1001][2];
//         dp[1][0] = 1;
//         dp[2][0] = 1;
//         dp[2][1] = 1;
//     }

//     static void solve() {
//         for (int i = 3; i <= n; i++) {
//             dp[i][0] = (dp[i-1][0] + dp[i-1][1])%10_007;
//             dp[i][1] = (dp[i-2][0] + dp[i-2][1])%10_007;
//         }
//     }
// }
