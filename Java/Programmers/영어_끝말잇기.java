import java.util.*;

class Solution {

    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]); // 단어의 길이는 2 이상
        for (int idx = 1; idx < words.length; idx++) {
            String curr = words[idx]; // 반복해서 호출하는 객체는 변수에 담아서 가독성 높여주기!!
            String prev = words[idx-1];
            if (set.contains(curr) || prev.charAt(prev.length()-1) != (curr.charAt(0))) {
                return new int[]{(idx%n)+1, (idx/n)+1};
            }

            set.add(words[idx]);
        }

        return new int[]{0, 0};
    }
} // 배열(primitive array)은 `.length` 필드를 가지고, 문자열(String)은 `.length()` 메서드를 가진다

// 첫 풀이:

// import java.util.*;

// class Solution {

//     public int[] solution(int n, String[] words) {
//         Set<String> set = new HashSet<>();
//         for (int idx = 0; idx < words.length; idx++) {
//             if (set.contains(words[idx])
//                || idx > 0 && !words[idx-1].substring(words[idx-1].length()-1).equals(words[idx].substring(0, 1))) {
//                 int num = (idx+1)%n;
//                 if (num == 0) num = n;
//                 return new int[]{num, (idx)/n + 1};
//             }

//             set.add(words[idx]);
//         }

//         return new int[]{0, 0};
//     }
// }
