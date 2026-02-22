import java.util.*;

class Solution {

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int it : tangerine) {
            mp.merge(it, 1, Integer::sum);
        }

        List<Integer> li = new ArrayList<>(mp.values());
        // li.sort((o1, o2) -> o2 - o1); // `o1 - o2` 일반적인 정렬 (오름차순), `o2 - o1` 역순 정렬 (내림차순)
        li.sort((o1, o2) -> Integer.compare(o2, o1)); // 오버플로우에 안전한 방식!

        int sum = 0;
        int ans = 0;
        for (int it : li) {
            sum += it;
            ans++;
            if (sum >= k) break;
        }

        return ans;
    }
}

// 첫 풀이 (배열을 써서 메모리를 너무 많이 사용함, 빈도만 있으면 되는데 불필요하게 value까지 정렬함)

// import java.util.*;

// class Solution {

//     int[] freq = new int[10000001];

//     public int solution(int k, int[] tangerine) {
//         for (int i = 0; i < tangerine.length; i++) {
//             int curr = tangerine[i];
//             freq[curr]++;
//         }

//         List<Node> li = new ArrayList<>();
//         for (int i = 1; i < 10000001; i++) {
//             if (freq[i] != 0) {
//                 li.add(new Node(i, freq[i]));
//             }
//         }
//         li.sort(Comparator.comparingInt((Node n) -> n.freq).thenComparingInt(n -> n.val).reversed());
//         int sum = 0;
//         int ans = 0;
//         for (int i = 0; i < li.size(); i++) {
//             sum += li.get(i).freq;
//             ans++;
//             if (sum >= k) break;
//         }

//         return ans;
//     }
// }

// class Node {

//     int val;
//     int freq;

//     Node(int val, int freq) {
//         this.val = val;
//         this.freq = freq;
//     }
// }
