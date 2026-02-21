import java.util.*;

class Solution {

    boolean solution(String s) {
        Deque<Character> stk = new ArrayDeque<>(); // 덱을 스택처럼 사용 (더 빠르다)

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stk.push('(');
            } else {
                if (!stk.isEmpty()) {
                    stk.pop();
                } else return false;
            }
        }

        return stk.isEmpty();
    }
}
