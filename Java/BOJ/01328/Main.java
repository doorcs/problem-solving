import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int L;
    static int R;
    static long mod = 1_000_000_007L; // long 리터럴 `L`
    static long[][][] dp = new long[101][101][101]; // 배열 크기에 변수 쓰지 말고, 입력값 범위에 따라 적당한 크기로 잡아두기

    public static void main(String[] args) {
        var st = new StringTokenizer(readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // dp = new long[N+1][L+1][R+1];
        // 배열 크기 잡을때 변수를 쓰면 이상한 테스트케이스에서 인덱스가 터질 수 있다!

        dp[1][1][1] = 1L;
        dp[2][1][2] = 1L;
        dp[2][2][1] = 1L;

        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                for (int k = 1; k <= R; k++) {
                    dp[i][j][k] = (dp[i-1][j-1][k] + dp[i-1][j][k-1] + dp[i-1][j][k] * (i-2)) % mod;
                }
            }
        }

        System.out.println(dp[N][L][R]);
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
