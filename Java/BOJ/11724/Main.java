// 큐 기반 BFS 풀이

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] vst = new boolean[N+1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (vst[i]) continue;
            ans++;
            bfs(graph, vst, i);
        }

        System.out.println(ans);
    }

    static void bfs(List<List<Integer>> graph, boolean[] vst, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        vst[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int next : graph.get(curr)) {
                if (vst[next]) continue;

                vst[next] = true;
                q.add(next);
            }
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// 첫 풀이 (콜 스택 기반 DFS)

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static int ans = 0;

//     public static void main(String[] args) throws IOException {
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());

//         List<List<Integer>> graph = new ArrayList<>();
//         boolean[] vst = new boolean[N+1];
//         for (int i = 0; i <= N; i++) {
//             graph.add(new ArrayList<>());
//         }

//         while (M-- > 0) {
//             st = new StringTokenizer(br.readLine());
//             int u = Integer.parseInt(st.nextToken());
//             int v = Integer.parseInt(st.nextToken());

//             graph.get(u).add(v);
//             graph.get(v).add(u); // 무방향 그래프니까 둘 다 추가해야함
//         }

//         for (int i = 1; i <= N; i++) {
//             if (vst[i]) continue;

//             ans++;
//             dfs(graph, vst, i);
//         }

//         System.out.println(ans);
//     }

//     static void dfs(List<List<Integer>> graph, boolean[] vst, int start) {
//         vst[start] = true;

//         for (int it : graph.get(start)) {
//             if (vst[it]) continue;
//             dfs(graph, vst, it);
//         }
//     }
// }
