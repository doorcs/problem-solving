import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int[] ans = new int[N];
        Arrays.fill(ans, -1); // Arrays 클래스의 메서드들 활용법 정리해두기
        Deque<Integer> stk = new ArrayDeque<>(); // Stack 보다 Deque(ArrayDeque)를 쓰는게 훨씬 빠르다!
        stk.push(0);

        for (int i = 1; i < N; i++) {
            while (!stk.isEmpty() && A[i] > A[stk.peek()]) {
                ans[stk.pop()] = A[i];
            }

            stk.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(' ');
        }

        System.out.println(sb.toString());
        br.close();
    }
}
