import java.util.*;

class Solution {

    public int solution(String s) {
        Deque<Character> dq = new ArrayDeque<>(s.length());
        for (char c : s.toCharArray()) dq.addLast(c);

        int ans = 0;
        for (int rep = 0; rep < s.length(); rep++) {
            if (isValid(dq)) ans++;

            dq.addLast(dq.removeFirst());
        }

        return ans;
    }

    static boolean isValid(Deque<Character> dq) {
        Deque<Character> stk = new ArrayDeque<>(dq.size());
        for (char curr : dq) {
            if ((curr == '(') || (curr == '{') || (curr == '[')) { // 여는 괄호면 무조건 스택에 넣을 수 있다
                stk.push(curr);
                continue;
            }

            if (stk.isEmpty()) { // 닫는 괄호 + 스택이 비어있다면 조기 종료 가능
                return false;
            }

            char top = stk.peek(); // 변수로 분리
            if ((curr == ')' && top == '(') ||
                (curr == '}' && top == '{') ||
                (curr == ']' && top == '[')) {
                stk.pop();
            } else {
                return false; // 닫는 괄호 + 스택 최상단의 여는 괄호랑 쌍이 안 맞는다면 조기 종료 가능
            }
        }

        return stk.isEmpty(); // 스택에 여는 괄호가 남아있을경우 false
    }
}

// 첫 풀이 (정답 처리는 받았는데 비효율적인 부분이 많다)

// import java.util.*;

// class Solution {

//     public int solution(String s) {
//         Deque<Character> dq = new ArrayDeque<>(s.length());
//         for (int i = 0; i < s.length(); i++) {
//             dq.addLast(s.charAt(i));
//         }

//         int ans = 0;
//         for (int rep = 0; rep < s.length(); rep++) {
//             if (isValid(dq)) ans++;

//             dq.addLast(dq.removeFirst());
//         }

//         return ans;
//     }

//     static boolean isValid(Deque<Character> dq) {
//         Deque<Character> stk = new ArrayDeque<>(dq.size());
//         for (char c : dq) {
//             if (stk.isEmpty()) {
//                 stk.push(c);
//                 continue;
//             }

//             if ((c == ')' && stk.peek() == '(')
//                || (c == '}' && stk.peek() == '{')
//                || (c == ']' && stk.peek() == '[')) {
//                 stk.pop();
//             } else {
//                 stk.push(c);
//             }
//         }

//         return stk.isEmpty();
//     }
// }
