import java.util.*;

class Solution {

    public int solution(int[] elements) {
        Set<Integer> s = new HashSet<>();

        int rep = elements.length;
        while (rep-- > 0) {
            int sum = 0;
            for (int i = rep; i < rep+elements.length; i++) {
                sum += elements[i%elements.length];
                s.add(sum);
            }
        } // 반복문 돌리면서 합이 될 수 있는 모든 경우의 수 찾기. O(n^2)이지만 문제 입력이 1000단위라 널널하다

        return s.size();
    }
}

// 첫 풀이 (Map 활용)

// import java.util.*;

// class Solution {

//     public int solution(int[] elements) {
//         Map<Integer, Integer> mp = new HashMap<>();

//         int rep = elements.length;
//         while (rep-- > 0) {
//             int sum = 0;
//             for (int i = rep; i < rep+elements.length; i++) {
//                 sum += elements[i%elements.length];
//                 mp.put(sum, mp.getOrDefault(sum, 0)+1);
//             }
//         }

//         return mp.size();
//     }
// }
