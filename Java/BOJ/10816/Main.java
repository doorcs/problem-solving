import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] cards;
    static int M;

    public static void main(String[] args) {
        setup();

        System.out.println(solve());
    }

    static void setup() {
        N = Integer.parseInt(readLine());
        cards = new int[N];
        var st = new StringTokenizer(readLine());
        for (int i = 0; i < N; i++) cards[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cards);
        M = Integer.parseInt(readLine());
    }

    static String solve() {
        var sb = new StringBuilder();
        var st = new StringTokenizer(readLine());

        for (int i = 0; i < M; i++) {
            int curr = Integer.parseInt(st.nextToken());
            sb.append(upperBound(curr)-lowerBound(curr)).append(' ');
        }

        return sb.toString();
    }

    static int lowerBound(int val) {
        int fr = -1;
        int rr = N;

        while (fr+1 < rr) {
            int mid = fr + (rr-fr)/2;
            if (cards[mid] < val) { // 조건: 현재 인덱스의 값이 `val보다 작은가`?
                fr = mid;
            } else {
                rr = mid;
            }
        }
        // 반복이 끝나면:

        // fr에는 조건을 만족하는(val보다 작은) 마지막 값의 인덱스,
        // rr에는 조건을 만족하지 않는(val보다 크거나 같은) 첫번째 값의 인덱스!!

        return rr;
    }

    static int upperBound(int val) {
        int fr = -1;
        int rr = N;

        while (fr+1 < rr) {
            int mid = fr + (rr-fr)/2;
            if (cards[mid] <= val) { // 조건: 현재 인덱스의 값이 `val보다 작거나 같은가`?
                fr = mid;
            } else {
                rr = mid;
            }
        }
        // 반복이 끝나면:

        // fr에는 조건을 만족하는(val보다 작거나 같은) 마지막 값의 인덱스,
        // rr에는 조건을 만족하지 않는(val보다 큰) 첫번째 값의 인덱스!

        return rr;
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
