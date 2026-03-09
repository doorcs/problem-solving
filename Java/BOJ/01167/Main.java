import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int V;
    static List<List<Node>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        dist = new int[V+1];
        Arrays.fill(dist, -1);

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= V; i++) {
            var st = new StringTokenizer(br.readLine());
            int curr = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break; // 두개씩 끊어 읽다가 -1까지 왔을경우 break
                int w = Integer.parseInt(st.nextToken());
                graph.get(curr).add(new Node(to, w));
            }
        }

        bfs(1);
        int maxDist = 0;
        int maxDistIdx = 1;
        for (int i = 1; i <= V; i++) {
            if (maxDist < dist[i]) {
                maxDist = dist[i];
                maxDistIdx = i;
            }
        }
        Arrays.fill(dist, -1);
        bfs(maxDistIdx);
        maxDist = 0;
        for (int i = 1; i <= V; i++) {
            if (maxDist < dist[i]) {
                maxDist = dist[i];
            }
        }

        System.out.println(maxDist);
    }

    static void bfs(int from) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(from, 0));
        dist[from] = 0;

        while (!q.isEmpty()) {
            Node curr = q.remove();
            int src = curr.to;
            int currCost = curr.w;

            for (Node next : graph.get(src)) {
                int dst = next.to;
                int nextCost = currCost + next.w;
                if (dist[dst] != -1) continue;
                dist[dst] = nextCost;
                q.add(new Node(dst, nextCost));
            }
        }
    }
}

class Node {

    int to;
    int w;

    Node(int to, int w) {
        this.to = to;
        this.w = w;
    }
}
