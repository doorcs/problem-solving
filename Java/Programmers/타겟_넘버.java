class Solution {

    public int solution(int[] numbers, int target) {
        return search(numbers, target, 0, 0);
    }

    int search(int[] numbers, int target, int depth, int sum) { // 굳이 List로 그래프를 안 만들어도 풀 수 있다
        if (depth == numbers.length) return sum == target ? 1 : 0;

        return search(numbers, target, depth+1, sum + numbers[depth])
            + search(numbers, target, depth+1, sum - numbers[depth]);
    }
}

// 첫 풀이:

// import java.util.*;

// class Solution {

//     static int ans = 0;

//     public int solution(int[] numbers, int target) {
//         int sz = numbers.length;
//         List<Integer> graph = new ArrayList<>();
//         for (int i = 0; i < sz; i++) graph.add(numbers[i]);

//         dfs(graph, 0, 0, target);
//         return ans;
//     }

//     void dfs(List<Integer> graph, int curr, int sum, int target) {
//         int plus = sum + graph.get(curr);
//         int minus = sum - graph.get(curr);

//         if (curr == graph.size()-1) {
//             if (plus == target) ans++;
//             if (minus == target) ans++;
//             return;
//         }

//         dfs(graph, curr+1, plus, target);
//         dfs(graph, curr+1, minus, target);
//     }
// }
