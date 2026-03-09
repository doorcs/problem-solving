import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static char[][] brd;
    static int[][] vst; // visited 배열을 `boolean[][]`이 아닌 `int[][]`로 관리
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        brd = new char[N][M];
        vst = new int[N][M];
        for (int i = 0; i < N; i++) {
            brd[i] = br.readLine().toCharArray();
        }

        bfs(0, 0);
        System.out.println(vst[N-1][M-1]);
    }

    static void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        vst[y][x] = 1;
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            var curr = q.remove();
            int cy = curr[0];
            int cx = curr[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || vst[ny][nx] > 0 || brd[ny][nx] == '0') continue;
                vst[ny][nx] = vst[cy][cx]+1;
                q.add(new int[]{ny, nx});
            }
        }

        return;
    }
}

// 첫 풀이 (
//     boolean[][] vst, int[][] dist 배열을 두 개 사용함 (하나로 합칠 수 있다)
// )

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static int N;
//     static int M;
//     static int[][] dist;
//     static char[][] brd;
//     static boolean[][] vst;
//     static int[] dy = new int[]{1, 0, -1, 0};
//     static int[] dx = new int[]{0, 1, 0, -1};

//     public static void main(String[] args) throws IOException {
//         var st = new StringTokenizer(br.readLine());
//         N = Integer.parseInt(st.nextToken());
//         M = Integer.parseInt(st.nextToken());

//         brd = new char[N][M];
//         vst = new boolean[N][M];
//         dist = new int[N][M];
//         for (int i = 0; i < N; i++) {
//             brd[i] = br.readLine().toCharArray();
//         }

//         bfs(0, 0);
//         System.out.println(dist[N-1][M-1]);
//     }

//     static void bfs(int y, int x) {
//         Queue<int[]> q = new ArrayDeque<>();
//         vst[y][x] = true;
//         dist[y][x] = 1;
//         q.add(new int[]{y, x});

//         while (!q.isEmpty()) {
//             var curr = q.remove();
//             int cy = curr[0];
//             int cx = curr[1];

//             for (int i = 0; i < 4; i++) {
//                 int ny = cy + dy[i];
//                 int nx = cx + dx[i];
//                 if (ny < 0 || nx < 0 || ny >= N || nx >= M || vst[ny][nx] || brd[ny][nx] == '0') continue;
//                 vst[ny][nx] = true;
//                 dist[ny][nx] = dist[cy][cx]+1;
//                 q.add(new int[]{ny, nx});
//             }
//         }

//         return;
//     }
// }
