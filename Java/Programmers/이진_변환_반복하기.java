import java.util.*;

class Solution {

    public int[] solution(String s) {
        int cnt = 0;
        int removed = 0;

        while (!s.equals("1")) {
            int tmp = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') tmp++;
            }

            s = Integer.toString(s.length()-tmp, 2); // toString()의 오버로딩 형태를 기억해두는게 더 좋을 것 같음
            removed += tmp;
            cnt++;
        }

        return new int[]{cnt, removed};
        // int[] ans = new int[2];
        // ans[0] = cnt;
        // ans[1] = removed;
        // return ans;
    }
}

// 첫 풀이:

// import java.util.*;

// class Solution {

//     public int[] solution(String s) {
//         int cnt = 0;
//         int removed = 0;

//         while (true) {
//             if (s.equals("1")) break;

//             int tmp = 0;
//             for (int i = 0; i < s.length(); i++) {
//                 if (s.charAt(i) == '0') tmp++;
//             }

//             s = Integer.toBinaryString(s.length()-tmp); // 찾아보고 쓴 메서드..
//             removed += tmp;
//             cnt++;
//         }

//         return new int[]{cnt, removed};
//     }
// }
