import java.util.*;

class Solution {

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B); // primitive type 배열의 경우 `Comparator.reverseOrder()`를 쓸 수 없다!!

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans += A[i] * B[A.length-i-1];
        }

        return ans;
    }
}

// `Integer[] B` 였다면 Arrays.sort(B, Comparator.reverseOrder()) 가능
