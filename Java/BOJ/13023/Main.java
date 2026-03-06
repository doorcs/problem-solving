import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        boolean[] vst = new boolean[N+1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean isExist = false;

        for (int i = 1; i <= N; i++) {
            if (dfs(graph, vst, i, 1)) {
                isExist = true;
                break;
            }
        }

        System.out.println(isExist ? 1 : 0);
    }

    static boolean dfs(List<List<Integer>> graph, boolean[] vst, int curr, int depth) {
        if (depth == 5) return true;
        vst[curr] = true;

        for (int next : graph.get(curr)) {
            if (vst[next]) continue;
            if (dfs(graph, vst, next, depth+1)) return true;
        }
        vst[curr] = false;

        return false;
    }
}
