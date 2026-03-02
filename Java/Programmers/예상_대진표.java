import java.util.*;

class Solution {

    public int solution(int n, int a, int b) {
        int ans = 0;
        while (a != b) {
            a = (a+1)/2;
            b = (b+1)/2;
            ans++;
        }

        return ans;
    }
}

// 첫 풀이 (a랑 b가 1 차이나고 a가 홀수가 되는 라운드에서 만난다는 점 활용)

// import java.util.*;

// class Solution {

//     public int solution(int n, int a, int b) {
//         if (a > b) {
//             int tmp = a;
//             a = b;
//             b = tmp;
//         } // a < b 고정

//         int ans = 1;
//         while (a+1 != b) {
//             a = (a+1)/2;
//             b = (b+1)/2;
//             ans++;
//         }

//         while (a%2 != 1) {
//             a = (a+1)/2;
//             b = (b+1)/2;
//             ans++;
//         }

//         return ans;
//     }
// }
