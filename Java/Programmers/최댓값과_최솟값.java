import java.util.*;

class Solution {

    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE; // min, MAX 반대로 초기화해두고 갱신하는 기법

        while (st.hasMoreTokens()) {
            int curr = Integer.parseInt(st.nextToken());
            if (curr > max) max = curr;
            if (curr < min) min = curr;
        }

        return new StringBuilder().append(min).append(' ').append(max).toString();
    }
}

// 첫 풀이:

// import java.util.*;

// class Solution {

//     public String solution(String s) {
//         StringTokenizer st = new StringTokenizer(s);
//         List<Integer> li = new ArrayList<>();
//         while (st.hasMoreTokens()) {
//             li.add(Integer.parseInt(st.nextToken()));
//         }
//         Collections.sort(li);

//         StringBuilder sb = new StringBuilder();
//         sb.append(li.get(0)).append(' ').append(li.get(li.size()-1));

//         return sb.toString();
//     }
// }
