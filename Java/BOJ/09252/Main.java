import java.io.*;
import java.util.*;

public class Main {

    static char[] s1;
    static char[] s2;
    static int[][] dp;

    public static void main(String[] args) {
        setup();

        System.out.println(solve());
    }

    static void setup() {
        s1 = readLine().toCharArray();
        s2 = readLine().toCharArray();
        dp = new int[s1.length+1][s2.length+1];
    }

    static String solve() {
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i-1] == s2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        var lcs = new StringBuilder();

        int i = s1.length;
        int j = s2.length;
        while (i > 0 && j > 0) {
            if (s1[i-1] == s2[j-1]) {
                lcs.append(s1[i-1]);
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        lcs.reverse(); // LCS 문자열이 sb에 역순으로 들어가있으니 순서 뒤집어주기

        var ret = new StringBuilder(); // 새로운 StringBuilder 생성
        ret.append(dp[s1.length][s2.length])
           .append('\n')
           .append(lcs); // LCS의 길이 -> 개행문자 -> LCS 순으로 append

        return ret.toString();
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

// 첫 풀이 (
//     O(N)짜리 무거운 연산인 StringBuilder.insert()를 사용함..
//     StringBuilder.append()에 다른 StringBuilder를 넘겨줄 수 있다는 사실을 몰랐음
// )

// import java.io.*;
// import java.util.*;

// public class Main {

//     static char[] s1;
//     static char[] s2;
//     static int[][] dp;

//     public static void main(String[] args) {
//         setup();

//         System.out.println(solve());
//     }

//     static void setup() {
//         s1 = readLine().toCharArray();
//         s2 = readLine().toCharArray();
//         dp = new int[s1.length+1][s2.length+1];
//     }

//     static String solve() {
//         for (int i = 1; i <= s1.length; i++) {
//             for (int j = 1; j <= s2.length; j++) {
//                 if (s1[i-1] == s2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
//                 else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//             }
//         }

//         var sb = new StringBuilder();

//         int i = s1.length;
//         int j = s2.length;
//         while (i > 0 && j > 0) {
//             if (s1[i-1] == s2[j-1]) {
//                 sb.append(s1[i-1]);
//                 i--;
//                 j--;
//             } else if (dp[i-1][j] > dp[i][j-1]) {
//                 i--;
//             } else {
//                 j--;
//             }
//         }
//         sb.reverse() // LCS 문자열이 sb에 역순으로 들어가있으니 순서 뒤집어주기
//           .insert(0, dp[s1.length][s2.length] + "\n"); // 맨 앞에 LCS의 길이와 개행문자 넣어주기

//         return sb.toString();
//     }

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static String readLine() {
//         try {
//             return br.readLine();
//         } catch (IOException e) {
//             throw new RuntimeException(e);
//         }
//     }
// }
