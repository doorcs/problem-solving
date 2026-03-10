import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] val;
    static int[] L;
    static int[] R;

    public static void main(String[] args) throws IOException {
        setup();

        System.out.println(solve());
    }

    static void setup() throws IOException {
        n = Integer.parseInt(br.readLine());
        val = new int[n+1];
        L = new int[n+1];
        R = new int[n+1];
        var st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) val[i] = Integer.parseInt(st.nextToken());

        L[1] = val[1];
        R[n] = val[n];
    }

    static int solve() {
        int max = L[1]; // 첫번째 요소로 초기화
        for (int i = 2; i <= n; i++) {
            L[i] = Math.max(val[i], val[i] + L[i-1]);
            max = Math.max(max, L[i]);
        }
        for (int i = n-1; i > 0; i--) {
            R[i] = Math.max(val[i], val[i] + R[i+1]);
        }
        for (int i = 2; i < n; i++) {
            max = Math.max(max, L[i-1]+R[i+1]); // Math.max()로 최댓값을 조건부 갱신할 때, 원래 값부터 쓰는게 더 보기 편한듯
        }

        return max;
    }
}

// 첫 풀이 ( 굳이굳이 입력값용 배열 따로 안 만들고 하려다 `R[n] = L[n]` 방향 실수함.. )

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static int n;
//     static int[] L;
//     static int[] R;

//     public static void main(String[] args) throws IOException {
//         setup();
//         System.out.println(solve());
//     }

//     static void setup() throws IOException {
//         n = Integer.parseInt(br.readLine());
//         L = new int[n+1];
//         R = new int[n+1];
//         var st = new StringTokenizer(br.readLine());
//         for (int i = 1; i <= n; i++) L[i] = Integer.parseInt(st.nextToken());
//         R[n] = L[n];
//     }

//     static int solve() {
//         int max = R[n];
//         for (int i = n-1; i > 0; i--) {
//             R[i] = Math.max(R[i+1]+L[i], L[i]);
//             max = Math.max(R[i], max);
//         }
//         for (int i = 2; i <= n; i++) {
//             L[i] = Math.max(L[i-1]+L[i], L[i]);
//         }
//         for (int i = 2; i < n; i++) {
//             max = Math.max(L[i-1]+R[i+1], max);
//         }

//         return max;
//     }
// }
