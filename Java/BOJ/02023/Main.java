import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 자릿수

        // 첫번째 자리에 올 수 있는 수의 후보는 딱 네개밖에 없다: 2, 3, 5, 7
        dfs(2, 1, N);
        dfs(3, 1, N);
        dfs(5, 1, N);
        dfs(7, 1, N);
    }

    static void dfs(int curr, int currDepth, int targetDepth) {
        if (!isPrime(curr)) return;

        if (currDepth == targetDepth) {
            System.out.println(curr);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            dfs(curr*10 + i, currDepth+1, targetDepth);
        }
    }

    static boolean isPrime(int N) {
        for (int i = 2; i*i <= N; i++) {
            if (N%i == 0) return false;
        }

        return true;
    }
}


// 최적화 시도 (메모리 초과)

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static Map<Integer, Boolean> mp = new HashMap<>(); // 소수 여부를 이미 판단했을 경우 추가 계산을 줄이기 위해

//     public static void main(String[] args) throws IOException {
//         int N = Integer.parseInt(br.readLine()); // 자릿수

//         for (int i = (int)Math.pow(10, N-1); i < (int)Math.pow(10, N); i++) {
//             var sb = new StringBuilder();
//             var arr = String.valueOf(i).toCharArray();
//             boolean isValid = true;
//             for (int j = 0; j < arr.length; j++) {
//                 sb.append(arr[j]);
//                 var curr = Integer.parseInt(sb.toString());
//                 if (!mp.containsKey(curr)) {
//                     if (!isPrime(curr)) {
//                         isValid = false;
//                         break;
//                     }
//                 }
//             }
//             if (isValid) System.out.println(i);
//         }
//     }

//     static boolean isPrime(int N) {
//         if (N == 1) return false;

//         for (int i = 2; i*i <= N; i++) {
//             if (N%i == 0) return false;
//         }

//         mp.put(N, true);
//         return true;
//     }
// }

// 첫 시도 (메모리 초과)

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     public static void main(String[] args) throws IOException {
//         int N = Integer.parseInt(br.readLine()); // 자릿수
//         long range = (long)Math.pow(10, N);
//         boolean[] sieve = new boolean[(int)range+1];
//         Arrays.fill(sieve, true);
//         sieve[1] = true;
//         sieve[2] = true;
//         for (int i = 2; i*i < range; i++) {
//             if (sieve[i]) {
//                 for (int j = i+i; j < range; j += i) sieve[j] = false;
//             }
//         }

//         for (int i = (int)Math.pow(10, N-1); i < range; i++) {
//             if (!sieve[i]) continue; // 소수가 아니면 스킵
//             var s = String.valueOf(i).toCharArray();
//             var sb = new StringBuilder();

//             boolean valid = true;
//             for (int j = 0; j < s.length; j++) {
//                 sb.append(s[j]);
//                 int curr = Integer.parseInt(sb.toString());
//                 if (!sieve[curr]) {
//                     valid = false;
//                     break;
//                 }
//             }

//             if (valid) System.out.println(i);
//         }
//     }
// }
