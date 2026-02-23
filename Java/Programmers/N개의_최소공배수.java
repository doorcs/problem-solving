import java.util.*;

class Solution {

    public int solution(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int prev = arr[i-1];
            int curr = arr[i];
            arr[i] = prev * curr / gcd(prev, curr);
        }
        return arr[arr.length-1];
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b); // b a b a b 로 기억하기. `b` == 0 ret `a` ret gcd(`b`, `a`%`b`)
    }
}

// `import java.math.BigInteger` 필요:

// int gcd(int a, int b) {
//     BigInteger.valueOf(a)
//               .gcd(BigInteger.valueOf(b))
//               .intValue();
// }
