import java.util.*;

class Solution {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int fr = 0; // 변수 하나로 가능
        for (int i = people.length - 1; i > fr; i--) {
            if (people[i] + people[fr] <= limit) {
                fr++;
            }
        }
        return people.length - fr;
    }
}

// 첫 풀이:

// import java.util.*;

// class Solution {

//     public int solution(int[] people, int limit) {
//         // 한 번에 최대 2명까지만 탈 수 있다 => 무거운 사람 태울때 한사람 더 태우면 무조건 이득!
//         Arrays.sort(people);
//         int saved = 0;
//         int front = 0;
//         for (int i = people.length-1; i > front; i--) { // 배열은 `.length()`가 아니라 `.length`다
//             if (people[i] + people[front] <= limit) {
//                 saved++;
//                 front++;
//             }
//         }
//         return people.length - saved;
//     }
// }
