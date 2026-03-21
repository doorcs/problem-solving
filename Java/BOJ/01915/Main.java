import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] brd;

    public static void main(String[] args) {
        setup();

        System.out.println(solve());
    }

    static void setup() {
        var st = new StringTokenizer(readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        brd = new int[N][M];
        for (int y = 0; y < N; y++) {
            var arr = readLine().toCharArray(); // char[]
            for (int x = 0; x < M; x++) {
                brd[y][x] = arr[x]-'0'; // char -> int
            }
        }
    }

    static int solve() {
        int largest = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (brd[y][x] != 0 && y > 0 && x > 0) {
                    brd[y][x] = Math.min(brd[y-1][x-1], Math.min(brd[y-1][x], brd[y][x-1]))+1;
                    // brd[y][x] == 해당 좌표를 우하단 꼭짓점으로 쓰는 제일 큰 정사각형의 한 변 크기
                }

                largest = Math.max(largest, brd[y][x]);
            }
        }

        return largest*largest; // 한 변의 길이가 아니라 정사각형의 넓이를 출력해야함!
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

// 첫 풀이 (`char[][]`에 보드 정보를 입력받고 별도의 `int[][] dp`를 만들어 사용함. 비효율적..)

// import java.io.*;
// import java.util.*;

// public class Main {

//     static int N;
//     static int M;
//     static char[][] brd;

//     public static void main(String[] args) {
//         setup();

//         System.out.println(solve());
//     }

//     static void setup() {
//         var st = new StringTokenizer(readLine());
//         N = Integer.parseInt(st.nextToken());
//         M = Integer.parseInt(st.nextToken());
//         brd = new char[N][M];
//         for (int y = 0; y < N; y++) {
//             brd[y] = readLine().toCharArray();
//         }
//     }

//     static int solve() {
//         int largest = 0;
//         int[][] dp = new int[N][M];

//         for (int y = 0; y < N; y++) {
//             for (int x = 0; x < M; x++) {
//                 if (brd[y][x] == '0') continue;

//                 if (y == 0 || x == 0) {
//                     dp[y][x] = 1;
//                 } else {
//                     dp[y][x] = Math.min(dp[y-1][x-1], Math.min(dp[y-1][x], dp[y][x-1]))+1;
//                 }

//                 largest = Math.max(largest, dp[y][x]);
//             }
//         }

//         return largest*largest; // 한 변의 길이가 아니라 정사각형의 넓이를 출력해야함!
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
