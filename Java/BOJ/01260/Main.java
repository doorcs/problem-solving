import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder(); // StringBuilder를 전역으로 빼서 `System.out.print()` 호출을 줄일 수 있다

    public static void main(String[] args) throws IOException {
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        boolean[] vst = new boolean[N+1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i <= N; i++) Collections.sort(graph.get(i)); // 방문할 수 있는 노드가 여러개일 경우 노드 번호가 작은것부터 방문

        dfs(graph, vst, V);
        sb.append('\n');
        Arrays.fill(vst, false);
        bfs(graph, vst, V);

        System.out.println(sb);
    }

    static void dfs(List<List<Integer>> graph, boolean[] vst, int curr) {
        vst[curr] = true;
        sb.append(curr).append(' ');

        for (int next : graph.get(curr)) {
            if (vst[next]) continue;
            dfs(graph, vst, next);
        }
    }

    static void bfs(List<List<Integer>> graph, boolean[] vst, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        vst[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();
            sb.append(curr).append(' ');

            for (int next : graph.get(curr)) {
                if (vst[next]) continue;
                vst[next] = true;
                q.add(next);
            }
        }
    }
}

// 첫 풀이:

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     public static void main(String[] args) throws IOException {
//         var st = new StringTokenizer(br.readLine());
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         int V = Integer.parseInt(st.nextToken());
//         boolean[] vst = new boolean[N+1];
//         List<List<Integer>> graph = new ArrayList<>();
//         for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

//         while (M-- > 0) {
//             st = new StringTokenizer(br.readLine());
//             int a = Integer.parseInt(st.nextToken());
//             int b = Integer.parseInt(st.nextToken());
//             graph.get(a).add(b);
//             graph.get(b).add(a);
//         }
//         for (int i = 0; i <= N; i++) Collections.sort(graph.get(i));

//         dfs(graph, vst, V);
//         System.out.println();
//         Arrays.fill(vst, false);
//         bfs(graph, vst, V);
//     }

//     static void dfs(List<List<Integer>> graph, boolean[] vst, int curr) {
//         vst[curr] = true;
//         System.out.print(curr + " ");

//         for (int next : graph.get(curr)) {
//             if (vst[next]) continue;
//             dfs(graph, vst, next);
//         }
//     }

//     static void bfs(List<List<Integer>> graph, boolean[] vst, int start) {
//         Queue<Integer> q = new ArrayDeque<>();
//         vst[start] = true;
//         q.add(start);

//         while (!q.isEmpty()) {
//             int curr = q.remove();
//             System.out.print(curr + " ");

//             for (int next : graph.get(curr)) {
//                 if (vst[next]) continue;
//                 vst[next] = true;
//                 q.add(next);
//             }
//         }
//     }
// }
