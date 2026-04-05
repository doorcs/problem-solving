import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr = new int[100_000_001];
    static int B;
    static int C;

    public static void main(String[] args) {
        N = Integer.parseInt(readLine());
        var st = new StringTokenizer(readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long ans = 0L;
        for (int i = 0; i < N; i++) {
            arr[i] -= B;
            ans++;
            if (arr[i] <= 0) continue;
            ans += (arr[i]+C-1) / C;
        }

        System.out.println(ans);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
