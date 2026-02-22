class Solution {

    public int solution(int n) { // 2 이상
        int fr = 0;
        int rr = 1;
        for (int i = 2; i <= n; i++) {
            int next = (fr + rr) % 1_234_567; // c = a + b일 때, c % mod == (a % mod + b % mod)
            fr = rr;
            rr = next;
        }

        return rr;
    }
}

// 첫 풀이:

// import java.util.*;

// class Solution {

//     int[] fib = new int[100_001];

//     public int solution(int n) { // 2 이상
//         fib[0] = 0;
//         fib[1] = 1;
//         for (int i = 2; i <= n; i++) {
//             fib[i] = (fib[i-1] + fib[i-2]) % 1_234_567;
//         }

//         return fib[n];
//     }
// }

// 첫 시도, 오답 (스택 오버플로우)

// class Solution {

//     public int solution(int n) {
//         return (int)(fib(n)%1234567L);
//     }

//     long fib(int n) {
//         if (n == 0) return 0;
//         if (n == 1) return 1;

//         return fib(n-1) + fib(n-2);
//     }
// }
