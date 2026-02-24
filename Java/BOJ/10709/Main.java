import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] brd = new int[H][W];
        for (int i = 0; i < H; i++) {
            String l = br.readLine();
            for (int j = 0; j < W; j++) {
                if (l.charAt(j) == 'c') brd[i][j] = 0;
                else brd[i][j] = -1;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 1; j < W; j++) {
                if (brd[i][j] == -1 && brd[i][j-1] != -1) {
                    brd[i][j] = brd[i][j-1] + 1;
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(brd[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 첫 풀이

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     public static void main(String[] args) throws IOException {
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int H = Integer.parseInt(st.nextToken());
//         int W = Integer.parseInt(st.nextToken());

//         char[][] brd = new char[H][W];
//         int[][] ans = new int[H][W];
//         for (int i = 0; i < H; i++) {
//             String l = br.readLine();
//             for (int j = 0; j < W; j++) {
//                 ans[i][j] = -1;
//                 brd[i][j] = l.charAt(j);
//                 if (l.charAt(j) == 'c') ans[i][j] = 0;
//             }
//         }

//         for (int i = 0; i < H; i++) {
//             for (int j = 1; j < W; j++) {
//                 if (ans[i][j] == -1 && brd[i][j-1] == 'c') {
//                     ans[i][j] = ans[i][j-1] + 1;
//                     brd[i][j] = 'c';
//                 }
//             }
//         }
//         for (int i = 0; i < H; i++) {
//             for (int j = 0; j < W; j++) {
//                 System.out.print(ans[i][j]);
//                 System.out.print(' ');
//             }
//             System.out.println();
//         }
//     }
// }
