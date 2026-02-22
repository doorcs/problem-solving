import java.util.*;

class Solution {

    public int solution(String s) {
        Deque<Character> stk = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (stk.isEmpty()) {
                stk.push(s.charAt(i));
                continue;
            }

            if (stk.peek() == s.charAt(i)) {
                stk.pop();
            } else {
                stk.push(s.charAt(i));
            }
        }

        return stk.isEmpty() ? 1 : 0; // 자바는 `(int)stk.isEmpty()`처럼 쓸 수 없다
    }
}
