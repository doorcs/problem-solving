import java.util.*;

class Solution {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = true; // 자바에서는 bool이 아니라 boolean

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(' ');
                isStart = true; // 공백 이후에는 `공백`이 또 나올수도 있고 `새로운 단어`가 나올수도 있다
            } else {
                sb.append(isStart ? Character.toUpperCase(c) : Character.toLowerCase(c));
                isStart = false;
            }
        }

        return sb.toString();
    }
}

// 첫 풀이:

// import java.util.*;

// class Solution {

//     public String solution(String s) {
//         StringTokenizer st = new StringTokenizer(s, " ", true); // 세번째 파라미터를 통해 구분자도 토큰에 포함시킬 수 있다
//         StringBuilder sb = new StringBuilder();

//         while (st.hasMoreTokens()) {
//             String str = st.nextToken();
//             if (str.equals(" ")) {
//                 sb.append(' ');
//                 continue;
//             }
//             String fr = str.substring(0, 1); // `.subString()`이 아니다.. 전부 소문자로 `.substring()`이다!
//             String rr = str.substring(1);
//             sb.append(fr.toUpperCase()).append(rr.toLowerCase());
//         }

//         return sb.toString();
//     }
// }
