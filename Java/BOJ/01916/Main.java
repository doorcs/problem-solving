import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>(N+1); // capacity 미리 확보
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        while (M-- > 0) {
            var st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(src).add(new Node(dst, cost));
        }

        var st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dst = Integer.parseInt(st.nextToken());
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            var curr = pq.remove();
            int from = curr.dst;
            int cost = curr.cost;
            if (cost != dist[from]) continue; // == (cost > dist[from])
            // 로직 구조상 `같은 정점`에 대해, `거리` 정보만 다른 (`정점`, `거리`) 원소가 큐에 여러번 들어갈 수 있다
            // 이때 `정점`까지의 `거리`가 현재까지 계산된 최단거리와 다르다면 오래된 데이터이므로 무시!! 바로 다음 원소를 뽑으러 가면 된다

            // ex: 큐에 {(2, 3), (2, 4), (2, 8)} 처럼 정점 `2`에 대해 거리 정보가 다른 노드 여러 개가 들어있는 상황

            // 큐에 (2, 3)이 add되는 순간 정점 `2`까지의 최단거리를 나타내는 `dist[2]` 값이 `3`으로 갱신된다

            // 이후 큐에서 (2, 4)나 (2, 8)을 뽑았을 경우, 정점 `2`까지의 거리가 `3`인 경로를 놔두고
            // 정점 `2`까지의 거리가 `4`나 `8`인 경로를 살펴볼 이유가 없음! -> skip

            for (var next : graph.get(from)) {
                int to = next.dst;
                int newCost = cost + next.cost;

                if (newCost >= dist[to]) continue;
                // `현재 위치까지의 거리 + 다음 위치로 가기 위한 거리` 가
                // `다음 위치로 가는 최단경로`를 갱신하지 못한다면 (크거나 같다면) continue

                // 해당 정점까지의 최단거리가 갱신될 때에만 거기서 연결된 정점들까지의 거리를 (다시) 계산해보는 것
                dist[to] = newCost;
                pq.add(new Node(to, newCost));
            }
        }

        System.out.println(dist[dst]);
    }
}

class Node {

    int dst;
    int cost;

    Node(int dst, int cost) {
        this.dst = dst;
        this.cost = cost;
    }
}
