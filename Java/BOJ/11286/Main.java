import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Comparator.<Integer>comparingInt(Math::abs).thenComparingInt(val -> val)
        ); // `+, 0, -` 기반 비교함수 작성 방법도 알아두기!!

        for (int i = 0; i < N; i++) {
            int curr = Integer.parseInt(br.readLine());
            if (curr == 0) {
                if (pq.isEmpty()) {
                    bw.write(String.valueOf(0));
                    bw.newLine();
                    continue;
                }
                bw.write(String.valueOf(pq.poll()));
                bw.newLine();
            } else {
                pq.add(curr);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

/* 첫 풀이:

PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
    if (Math.abs(a) == Math.abs(b)) {
        return a - b;
    }
    return Math.abs(a) - Math.abs(b);
});

*/
