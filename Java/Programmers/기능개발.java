import java.util.*;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            int needed = 100-progresses[i];
            q.add((needed+speeds[i]-1) / speeds[i]);
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.remove();
            int cnt = 1;

            while (!q.isEmpty() && q.peek() <= curr) {
                q.remove();
                cnt++;
            }

            ans.add(cnt);
        }

        return ans.stream()
                  .mapToInt(i -> i) // 오토 언박싱 활용. `Integer::intValue` 쓰는거보다 훨씬 짧다
                  .toArray();
    }
}

// 첫 풀이 (큐 없이 배열이랑 카운터로 접근)

// import java.util.*;

// class Solution {

//     public int[] solution(int[] progresses, int[] speeds) {
//         int days = 1;
//         int sz = progresses.length;
//         int[] fin = new int[sz];
//         int finCnt = 0;

//         while (finCnt != sz) {
//             for (int i = 0; i < sz; i++) {
//                 progresses[i] += speeds[i];
//                 if (progresses[i] > 99 && fin[i] == 0) {
//                     fin[i] = days;
//                     finCnt++;
//                 }
//             }
//             days++;
//         }

//         List<Integer> ans = new ArrayList<>();
//         int cnt = 1;
//         int curr = fin[0];
//         for (int i = 1; i < sz; i++) {
//             if (fin[i] <= curr) cnt++;
//             else {
//                 ans.add(cnt);
//                 curr = fin[i];
//                 cnt = 1;
//             }
//         }
//         ans.add(cnt);

//         return ans.stream()
//                   .mapToInt(i -> i)
//                   .toArray();
//     }
// }
