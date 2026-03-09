import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) dp[i] = dp[i-1] + dp[i-2]; // 바텀업 DP

        System.out.println(dp[n]);
    }
}

// 탑다운 DP

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static int[] dp;

//     public static void main(String[] args) throws IOException {
//         int n = Integer.parseInt(br.readLine());
//         dp = new int[46];
//         Arrays.fill(dp, -1);
//         dp[0] = 0;
//         dp[1] = 1;
//         fib(n);

//         System.out.println(dp[n]);
//     }

//     static int fib(int n) {
//         if (dp[n] != -1) return dp[n]; // 이미 계산했던 부분일 경우 재계산 X

//         return dp[n] = fib(n-1) + fib(n-2);
//     }
// }
