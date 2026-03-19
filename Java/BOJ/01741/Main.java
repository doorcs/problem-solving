import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[] sieve;

    public static void main(String[] args) {
        N = Integer.parseInt(readLine());
        sieve = new boolean[1_500_001]; // 버퍼가 필요할 경우 `1.5배`를 하면 대부분의 경우에 적당함!
        Arrays.fill(sieve, true);
        sieve[1] = false;
        for (int i = 2; i*i <= 1_500_000; i++) { //
            if (sieve[i]) { // 현재 수가 소수라면
                for (int j = i*i; j <= 1_500_000; j+=i) sieve[j] = false; // 그 배수는 모두 소수가 아니다
            }
        }

        for (int i = N; i <= 1_500_000; i++) {
            if (sieve[i]) {
                char[] curr = String.valueOf(i).toCharArray();
                int fr = 0;
                int rr = curr.length-1;
                boolean isValid = true;

                while (fr < rr) {
                    if (curr[fr] != curr[rr]) {
                        isValid = false;
                        break;
                    }
                    fr++;
                    rr--;
                }

                if (isValid) {
                    System.out.println(i);
                    return;
                }
            }
        }
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

// 첫 풀이 (String으로 두고 charAt() 반복 호출해서 비효율적임)

// import java.io.*;
// import java.util.*;

// public class Main {

//     static int N;
//     static boolean[] sieve;

//     public static void main(String[] args) {
//         N = Integer.parseInt(readLine());
//         sieve = new boolean[1_500_001]; // 버퍼가 필요할 경우 `1.5배`를 하면 대부분의 경우에 적당함!
//         Arrays.fill(sieve, true);
//         sieve[1] = false;
//         for (int i = 2; i*i <= 1_500_000; i++) { //
//             if (sieve[i]) { // 현재 수가 소수라면
//                 for (int j = i*i; j <= 1_500_000; j+=i) sieve[j] = false; // 그 배수는 모두 소수가 아니다
//             }
//         }

//         for (int i = N; i <= 1_500_000; i++) {
//             if (sieve[i]) {
//                 String curr = String.valueOf(i);
//                 int fr = 0;
//                 int rr = curr.length()-1;
//                 boolean isValid = true;

//                 while (fr < rr) {
//                     if (curr.charAt(fr) != curr.charAt(rr)) {
//                         isValid = false;
//                         break;
//                     }
//                     fr++;
//                     rr--;
//                 }

//                 if (isValid) {
//                     System.out.println(i);
//                     return;
//                 }
//             }
//         }
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
