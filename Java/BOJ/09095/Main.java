import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int T;
    static int[] dp;

    public static void main(String[] args) {
        setup();

        System.out.println(solve());
    }

    static void setup() {
        T = Integer.parseInt(readLine());
        dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4; // `1 1 1`, `1 2`, `2 1`, `3`
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; // N값의 범위가 10 이하로 작으니 미리 계산해두고 시작
        }
    }

    static String solve() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int curr = Integer.parseInt(readLine());
            sb.append(dp[curr]).append('\n');
        }

        return sb.toString();
    }

    static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static int T;
//     static int[] dp;
//     static StringBuilder sb = new StringBuilder();

//     public static void main(String[] args) throws IOException {
//         setup();
//         solve();

//         System.out.println(sb);
//     }

//     static void setup() throws IOException {
//         T = Integer.parseInt(br.readLine());
//         dp = new int[11];

//         dp[1] = 1;
//         dp[2] = 2;
//         dp[3] = 4; // 1 1 1, 1 2, 2 1, 3
//         for (int i = 4; i <= 10; i++) {
//             dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
//         }
//     }

//     static void solve() throws IOException {
//         for (int i = 0; i < T; i++) {
//             int curr = Integer.parseInt(br.readLine());
//             sb.append(dp[curr]).append('\n');
//         }
//     }
// }
