import java.io.*;
import java.util.*;

public class Main {

    static int K; // 랜선 수
    static int N; // 필요한 랜선 수
    static long max = 0L;
    static long[] arr;

    public static void main(String[] args) {
        setup();

        System.out.println(solve());
    }

    static void setup() {
        var st = new StringTokenizer(readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(readLine());
            max = Math.max(max, arr[i]); // 제일 긴 랜선 길이에서 시작
        }
    }

    // static long solve() { // 파라메트릭 서치
    //     long fr = 1L;
    //     long rr = max;

    //     while (fr <= rr) {
    //         long mid = fr + (rr-fr)/2; // 오버플로우 걱정 없는 연산
    //         // long mid = fr/2 + rr/2 + (fr&rr&1); // 오버플로우 걱정 없고, 대소관계도 상관 없는 방법
    //         // long mid = (fr+rr) >>> 1; // 자바의 `Arrays.binarySearch()`에서 사용하는 방식, 이것도 오버플로우 걱정 X!
    //         if (check(mid)) {
    //             fr = mid+1;
    //         } else {
    //             rr = mid-1;
    //         }
    //     }

    //     return rr;
    // }

    static long solve() {
        long fr = 0;     // 조건을 무조건 만족하는 값에서 출발
        long rr = max+1; // 조건을 무조건 만족하지 않는 값에서 출발

        while (fr+1 < rr) { // `만족 + 1` == `불만족`, 즉 만족하는 값과 불만족하는 값이 딱 붙을때까지 반복
            long mid = fr + (rr-fr)/2;
            if (check(mid)) {
                fr = mid;
            } else {
                rr = mid;
            }
        }

        return fr; // 만족하는 최댓값인 fr 리턴!
    }

    static boolean check(long len) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += arr[i]/len;
        }

        return cnt >= N ? true : false;
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
