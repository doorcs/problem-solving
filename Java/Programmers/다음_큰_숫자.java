import java.util.*;

class Solution {

    public int solution(int n) {
        int diff = 1;

        while (true) {
            String curr = Integer.toString(n, 2);
            String next = Integer.toString(n+diff, 2);
            int a = 0;
            int b = 0; // c, n을 쓰고싶은데 솔루션 함수의 파라미터에서 n을 사용

            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) == '1') a++;
            }
            for (int i = 0; i < next.length(); i++) {
                if (next.charAt(i) == '1') b++;
            }

            if (a == b) return n + diff;
            diff++;
        }
    }
}
