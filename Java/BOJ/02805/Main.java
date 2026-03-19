// 첫 풀이 (전부 int -> long으로 바꿔줌)

/* 자바에서는 long -> int 암시적 캐스팅을 막기 때문에, long 사용시 주의점이 있다:

 * 1. 배열의 크기, 자바 Collection의 인덱스, 크기 관련 메서드는 모두 파라미터로 int를 받고 int를 리턴한다!
 *
 *     - Queue.size()                    // 컬렉션의 size()는 항상 int형을 리턴함
 *     - long[] arr = new long[(int)3L]  // 배열의 크기는 int형만 가능
 *     - List.get(3)                     // 인덱스는 int형이어야 함
 *     - String.charAt(7)                // 인덱스는 int형이어야 함
 *     - String.substring(2, 3);         // 인덱스는 int형이어야 함

 * 2. 숫자 리터럴에 `L` 접미사를 붙여주지 않으면 int 취급이다!!
 *
 *     long wrong = 1_000_000_000 * 1_000_000_000;  // 이러면 int*int라 오버플로우 발생!!!
 *     long right = 1_000_000_000L * 1_000_000_000; // 한쪽에 `L`을 붙여서 long 리터럴로 만들어줘야 오버플로우 안 생김
 */

import java.io.*;
import java.util.*;

public class Main {

    static long N; // 나무의 수
    static long M; // 가져갈 나무 길이
    static long[] arr;

    static long maximum = 0L;

    public static void main(String[] args) {
        setup();

        System.out.println(solve());
    }

    static void setup() {
        var st = new StringTokenizer(readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new long[(int)N];
        st = new StringTokenizer(readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            maximum = Math.max(maximum, arr[i]);
        }
    }

    static long solve() {
        long fr = 0L;
        long rr = maximum;

        while (fr+1 < rr) {
            long mid = fr + (rr-fr)/2;
            if (check(mid)) {
                fr = mid;
            } else {
                rr = mid;
            }
        }

        return fr;
    }

    static boolean check(long height) {
        long tot = 0L;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]-height > 0) tot += arr[i]-height;
        }

        return tot >= M;
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

// 오버플로우가 발생할 수 있는 부분만 long으로 바꾼 풀이
// 근데 복잡하게 생각하지 말고, 수 범위가 좀 크다 싶으면 전부 long으로 푸는게 마음 편할듯

// import java.io.*;
// import java.util.*;

// public class Main {

//     static int N; // 나무의 수
//     static int M; // 가져갈 나무 길이
//     static int[] arr;

//     static int maximum = 0;

//     public static void main(String[] args) {
//         setup();

//         System.out.println(solve());
//     }

//     static void setup() {
//         var st = new StringTokenizer(readLine());
//         N = Integer.parseInt(st.nextToken());
//         M = Integer.parseInt(st.nextToken());
//         arr = new int[N];
//         st = new StringTokenizer(readLine());
//         for (int i = 0; i < N; i++) {
//             arr[i] = Integer.parseInt(st.nextToken());
//             maximum = Math.max(maximum, arr[i]);
//         }
//     }

//     static int solve() {
//         int fr = 0;
//         int rr = maximum;

//         while (fr+1 < rr) {
//             int mid = fr + (rr-fr)/2;
//             if (check(mid)) {
//                 fr = mid;
//             } else {
//                 rr = mid;
//             }
//         }

//         return fr;
//     }

//     static boolean check(int height) {
//         long tot = 0; // 오버플로우가 발생할 가능성이 있는건 tot뿐이다
//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i]-height > 0) tot += arr[i]-height;
//         }

//         return tot >= (int)M; // M 자체는 20억 이하라는 조건이 있음 == int형으로 커버 가능
//     }

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static String readLine() {
//         try {
//             return br.readLine();
//         } catch (IOException e) {
//             throw new RuntimeException(e);
//         }
//     }
// }

