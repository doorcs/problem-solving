class Solution {

    public int solution(int n) {
        int fr = 1;
        int rr = 1;
        long sum = 1;
        int ans = 0;

        while (rr <= n) {
            if (sum == n) ans++;

            if (sum >= n) {
                sum -= fr;
                fr++;
            } else {
                rr++;
                sum += rr;
            }
        }

        return ans;
    }
}

// 첫 풀이:

// class Solution {

//     public int solution(int n) {
//         if (n == 1 || n == 2) return 1;

//         int fr = 1;
//         int rr = 2;
//         int ans = 0;
//         while (rr <= n) {
//             long sum = 0;
//             for (int i = fr; i <= rr; i++) {
//                 sum += i;
//             }

//             if (sum == n) {
//                 ans++;
//             }

//             if (sum > n) {
//                 fr++;
//             } else {
//                 rr++;
//             }
//         }

//         return ans;
//     }
// }
