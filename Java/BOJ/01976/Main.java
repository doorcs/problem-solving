import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        DSU dsu = new DSU(N);

        for (int i = 1; i <= N; i++) {
            var st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int curr = Integer.parseInt(st.nextToken());
                if (curr == 0) continue;
                dsu.union(i, j);
            }
        }

        var st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int parent = dsu.find(first);
        // for (int i = 1; i < M; i++) {
        while (st.hasMoreTokens()) {
            int curr = Integer.parseInt(st.nextToken());
            if (dsu.find(curr) != parent) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}

class DSU {

    int[] parent;
    int[] size;

    DSU(int n) {
        parent = new int[n+1];
        size = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return false;

        if (ra < rb) {
            int tmp = ra; ra = rb; rb = tmp;
        }
        parent[rb] = ra;
        size[ra] += size[rb];
        return true;
    }
}
