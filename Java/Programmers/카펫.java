class Solution {

    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;

        for (int col = 3; col*col <= sum; col++) { // col을 작은 수부터 증가시키면 자동으로 row는 큰 수부터 감소!
            int row = sum/col;
            if ((row-2)*(col-2) == yellow) return new int[]{row, col};
        }

        return new int[]{}; // 문제 조건상 도달할 일 없지만, 런타임 에러 방지용
    }
}

// 첫 풀이:

// class Solution {

//     public int[] solution(int brown, int yellow) {
//         int sum = brown + yellow;
//         int row = 3;

//         while (true) {
//             int col = sum / row;

//             if ((row-2) * (col-2) == yellow) break;
//             row++;
//         }
//         int col = sum/row;
//         if (row < col) {
//             int tmp = row;
//             row = col;
//             col = tmp;
//         }

//         return new int[]{row, col};
//     }
// }
