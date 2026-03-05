import java.util.*;

class Solution {

    public boolean solution(String[] phone_book) {
        Map<String, Integer> mp = new HashMap<>();
        for (String s : phone_book) mp.put(s, 1);

        for (String s : phone_book) {
            var sb = new StringBuilder();
            var arr = s.toCharArray();
            for (int i = 0; i < arr.length-1; i++) {
                sb.append(arr[i]);
                String prefix = sb.toString();
                if (mp.containsKey(prefix)) return false;
            }
        }
        return true;
    }
}

// 첫 풀이:

// import java.util.*;

// class Solution {

//     public boolean solution(String[] phone_book) {
//         Map<String, Integer> mp = new HashMap<>();
//         for (String s : phone_book) mp.put(s, 1);

//         for (String s : phone_book) {
//             var sb = new StringBuilder();
//             for (char c : s.toCharArray()) {
//                 sb.append(c);
//                 String prefix = sb.toString();
//                 if (mp.containsKey(prefix) && !prefix.equals(s)) return false;
//             }
//         }
//         return true;
//     }
// }
