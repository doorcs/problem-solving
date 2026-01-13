import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> dq = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int curr = Integer.parseInt(st.nextToken());
            while (!dq.isEmpty() && dq.getLast().val > curr) {
                dq.pollLast();
            }
            dq.addLast(new Node(i, curr));

            if (dq.getFirst().idx < i-L+1) {
                dq.pollFirst();
            }

            bw.write(String.valueOf(dq.getFirst().val));
            bw.write(" "); // 코드 실행시 불필요한 StringBuilder가 사용되지 않도록!
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Node {

    int idx;
    int val;

    Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

// 자바에서 기본(default) 접근 제어 지시자는 package-private
// 패키지 외부에서는 private과 같고, 패키지 안에서는 public과 같다
// -> 알고리즘 문풀에서 헬퍼 클래스는 접근 지시자 없이 써도 상관없을듯!

// + 2026.01.13 기준 백준에서 지원하는 최신 자바 버전은 Java15
// 이런 용도에는 레코드가 참 잘 어울릴 것 같은데 쓸 수가 앖다..

// record Node(int idx, int val) {}
