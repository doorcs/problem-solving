import java.util.*;

class Solution {

    public int solution(String[][] clothes) {
        Map<String, Integer> mp = new HashMap<>();
        for (String[] arr : clothes) {
            String part = arr[1];
            mp.put(part, mp.getOrDefault(part, 0)+1);
        }

        int ans = 1; // 곱해나가야 하니 1로 두고 시작
        for (int it : mp.values()) {
            ans *= (it+1); // 카테고리에 옷이 n개라면, 추가되는 전체 경우의 수는 n+1 (그 카테고리에서 아무것도 안 입을수도 있으니 +1)
        }

        return ans-1; // `하루에 최소 한 개의 의상은 입는다`는 조건이 있으니, 전체 경우의 수에서 아무것도 안 입는 경우 빼주기
    }
}
