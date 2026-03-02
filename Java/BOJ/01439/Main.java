import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        char[] arr = S.toCharArray(); // `.toCharArray()`랑 인덱스로 접근하는게 `.charAt()` 반복하는것보다 효율적이다

        int ones = 0;
        int zeros = 0;

        if (arr[0] == '1') ones++;
        else zeros++;

        for (int i = 1; i < S.length(); i++) {
            if (arr[i] != arr[i-1]) { // 종류가 바뀔 때만 카운팅하면 됨!
                if (arr[i] == '1') ones++;
                else zeros++;
            }
        }

        System.out.println(Math.min(ones, zeros));
    }
}

// 첫 풀이:

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     public static void main(String[] args) throws IOException {
//         String S = br.readLine();
//         int sz = S.length();

//         int ones = 0;
//         int zeros = 0;
//         if (S.charAt(0) == '1') {
//             ones++;
//         } else {
//             zeros++;
//         }

//         for (int i = 1; i < sz; i++) {
//             if (S.charAt(i) == '1' && S.charAt(i-1) != '1') {
//                 ones++;
//             } else if (S.charAt(i) == '0' && S.charAt(i-1) != '0') {
//                 zeros++;
//             }
//         }

//         // int ans = ones > zeros ? zeros : ones;
//         // System.out.println(ans);
//         System.out.println(Math.min(ones, zeros));
//     }
// }
