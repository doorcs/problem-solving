import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        var sb = new StringBuilder();
        var st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        var dsu = new DSU(n);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                dsu.union(a, b);
            } else {
                if (dsu.find(a) == dsu.find(b)) sb.append("YES").append('\n'); // if (dsu.same(a, b))
                else sb.append("NO").append('\n');
            }
        }

        // sb.deleteCharAt(sb.length()-1); 백준에서는 없어도 되지만, 프로그래머스 환경 대비해서 템플릿으로 기억해두기
        System.out.println(sb);
    }
}

class DSU {

    int[] parent;
    int[] size;

    DSU(int N) {
        parent = new int[N+1];
        size = new int[N+1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x; // `x == parent[x]` 의 의미? `루트까지 올라왔다`
    }

    boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return false;

        if (size[ra] < size[rb]) { // ra가 rb보다 작다면, 무조건 ra가 더 크게 만들어주고 시작
            int tmp = ra;
            ra = rb;
            rb = tmp;
        }
        parent[rb] = ra; // 작은놈의 부모를 큰 놈으로 바꾼다 == 큰 놈을 작은놈의 부모로 만든다
        size[ra] += size[rb]; // 부모의 크기를 자식 크기만큼 키운다

        return true;
    }

    // 유틸리티 메서드 (Optional)

    // boolean same(int a, int b) {
    //     return find(a) == find(b);
    // }
}
