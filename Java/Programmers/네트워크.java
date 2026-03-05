// 개선해본 풀이.. 인데 코테에서도 이렇게 풀 수 있을지는 모르겠음

class Solution {

    public int solution(int n, int[][] computers) {
        boolean[] vst = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vst[i]) continue;
            ans++;
            dfs(computers, vst, i);
        }

        return ans;
    }

    static void dfs(int[][] computers, boolean[] vst, int curr) {
        if (vst[curr]) return;
        vst[curr] = true;

        for (int i = 0; i < computers[curr].length; i++) {
            if (computers[curr][i] == 0) continue;
            dfs(computers, vst, i);
        }
    }
}

// 첫 풀이 (배열 정보 바탕으로 그래프 만들어서 dfs)

// import java.util.*;

// class Solution {

//     public int solution(int n, int[][] computers) {
//         List<List<Integer>> graph = new ArrayList<>();
//         for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
//         boolean[] vst = new boolean[n];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (computers[i][j] == 0) continue;
//                 graph.get(i).add(j);
//                 graph.get(j).add(i);
//             }
//         }

//         int ret = 0;
//         for (int i = 0; i < n; i++) {
//             if (vst[i]) continue;
//             ret++;
//             dfs(graph, vst, i);
//         }

//         return ret;
//     }

//     static void dfs(List<List<Integer>> graph, boolean[] vst, int curr) {
//         if (vst[curr]) return;
//         vst[curr] = true;

//         for (var next : graph.get(curr)) {
//             dfs(graph, vst, next);
//         }
//     }
// }
