import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] T;
    static int[] P;
    static int[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        dp = new int[N+2];

        for (int i = 1; i <= N; i++) {
            var st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; ++i) { // 바텀업 DP
            dp[i+1] = Math.max(dp[i+1] , dp[i]);
            if(i+T[i]-1 <= N) dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
        }

        System.out.println(dp[N+1]);
    }
}

// 탑다운 DP

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static int[] T;
//     static int[] P;
//     static int[] dp;
//     static int N;

//     public static void main(String[] args) throws IOException {
//         N = Integer.parseInt(br.readLine());
//         T = new int[N+1];
//         P = new int[N+1];
//         dp = new int[N+2];

//         for (int i = 1; i <= N; i++) {
//             var st = new StringTokenizer(br.readLine());
//             T[i] = Integer.parseInt(st.nextToken());
//             P[i] = Integer.parseInt(st.nextToken());
//         }

//         for (int i = N; i > 0; i--) {
//             if (i+T[i]-1 > N) {
//                 dp[i] = dp[i+1];
//             } else {
//                 dp[i] = Math.max(dp[i+1], P[i]+dp[i+T[i]]);
//             }
//         }

//         System.out.println(dp[1]);
//     }
// }

// 첫 풀이 ( DP 풀이가 안 떠올라서 재귀 브루트포스.. )

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static int[] T;
//     static int[] P;
//     static int N;
//     static int ans;

//     public static void main(String[] args) throws IOException {
//         N = Integer.parseInt(br.readLine());
//         T = new int[N+1];
//         P = new int[N+1];

//         for (int i = 1; i <= N; i++) {
//             var st = new StringTokenizer(br.readLine());
//             T[i] = Integer.parseInt(st.nextToken());
//             P[i] = Integer.parseInt(st.nextToken());
//         }
//         calc(1, 0);

//         System.out.println(ans);
//     }

//     static void calc(int idx, int curr) {
//         if (idx > N) {
//             ans = Math.max(ans, curr);
//             return;
//         }

//         if (idx+T[idx]-1 <= N) calc(idx+T[idx], curr+P[idx]);
//         calc(idx+1, curr);
//     }
// }
