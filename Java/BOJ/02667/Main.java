import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        // boolean[][] vst = new boolean[N][N];
        // char[][] brd = new char[N][N];
        var vst = new boolean[N][N];
        var brd = new char[N][N];

        for (int rep = 0; rep < N; rep++) {
            // var s = br.readLine().toCharArray();
            // for (int i = 0; i < s.length; i++) {
            //     brd[rep][i] = s[i];
            // }
            brd[rep] = br.readLine().toCharArray(); // 익숙해지면 좋겠지만, 기억 안 나면 반복문 돌리자
        }

        List<Integer> ans = new ArrayList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (vst[y][x] || brd[y][x] == '0') continue;
                ans.add(bfs(brd, vst, y, x));
                // ans.add(dfs(brd, vst, y, x));
            }
        }

        Collections.sort(ans); // (ans, (o1, o2) -> Integer.compare(o1, o2)) // (ans, (o1, o2) -> o1 - o2)
        // System.out.println(ans.size());
        // for (int it : ans) System.out.println(it);
        var sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        for (int it : ans) sb.append(it).append('\n');
        System.out.println(sb);
    }

    static int bfs(char[][] brd, boolean[][] vst, int y, int x) {
        int ret = 1;
        Queue<int[]> q = new ArrayDeque<>();
        vst[y][x] = true;
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            var curr = q.remove();
            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= brd.length || nx >= brd[0].length || vst[ny][nx] || brd[ny][nx] == '0') continue;
                vst[ny][nx] = true;
                ret++;
                q.add(new int[]{ny, nx});
            }
        }

        return ret;
    }

    static int dfs(char[][] brd, boolean[][] vst, int y, int x) {
        int ret = 1;
        vst[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= brd.length || nx >= brd[0].length || vst[ny][nx] || brd[ny][nx] == '0') continue;
            ret += dfs(brd, vst, ny, nx); // 재귀 DFS에서 탐색한 노드 수 합계 구하는 방법 기억하기!
        }

        return ret;
    }
}
