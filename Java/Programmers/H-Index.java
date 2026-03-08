import java.util.*;

class Solution {

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int ans = 0;
        for (int i = 0; i < citations.length; i++) {
            int candid = Math.min(citations[i], citations.length-i);
            ans = Math.max(ans, candid);
        }

        return ans;
    }
}

// 첫 풀이

// import java.util.*;

// class Solution {

//     public int solution(int[] citations) {
//         Map<Integer, Integer> mp = new TreeMap<>(); // key 오름차순 정렬
//         for (int it : citations) mp.put(it, mp.getOrDefault(it, 0)+1);

//         int ret = 0;
//         int tot = citations.length;
//         int cum = 0;
//         for (var e : mp.entrySet()) {
//             int h = e.getKey();
//             int cnt = e.getValue();
//             if (tot - cum >= ret) ret = Math.min(h, tot-cum);
//             cum += cnt;
//         }

//         return ret;
//     }
// }
