// Map 메서드들을 활용한 Set 없는 풀이

import java.util.*;

class Solution {

    public int solution(String[] want, int[] number, String[] discount) {
        // number 원소들의 `합이 무조건 10`이라는 조건이 있었다!! 문제를 자세히 읽고 시작하자!! 타이핑부터 하지 말고
        Map<String, Integer> wants = new HashMap<>(want.length * 2);
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], wants.getOrDefault(want[i], 0)+number[i]);
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            String curr = discount[i];
            if (wants.containsKey(curr)) {
                wants.put(curr, wants.getOrDefault(curr, 0)-1);
            }
        }

        if (check(wants)) ans++;

        for (int i = 10; i < discount.length; i++) {
            String curr = discount[i];
            String prev = discount[i-10];
            if (wants.containsKey(curr)) {
                wants.put(curr, wants.getOrDefault(curr, 0)-1); // 새로 들어오는거
            }
            if (wants.containsKey(prev)) {
                wants.put(prev, wants.getOrDefault(prev, 0)+1); // 나가는거
            }

            if (check(wants)) ans++;
        }

        return ans;
    }

    // 반복되는 로직이 있다면 함수 분리 고려하기 (여유 될 때)
    static boolean check(Map<String, Integer> wants) {
        for (var cnt : wants.values()) { // 그냥 value들을 꺼내서 확인하면 된다. 굳이 Set 안 써도 됨
            if (cnt > 0) return false;
        }

        return true;
    }
    // 스트림을 활용할 수도 있다:

    // static boolean check(Map<String, Integer> wants) {
    //     return wants.values().stream().noneMatch(v -> v > 0); // 만족하지 않는 항을 만나면 early return
    // }
}

// 두번째 풀이 (
//     중복 로직을 함수로 분리,
//     불필요한 연산을 줄임
// )

// import java.util.*;

// class Solution {

//     public int solution(String[] want, int[] number, String[] discount) {
//         // number 원소들의 `합이 무조건 10`이라는 조건이 있었다!! 문제를 자세히 읽고 시작하자!! 타이핑부터 하지 말고
//         Map<String, Integer> wants = new HashMap<>();
//         Set<String> prods = new HashSet<>();
//         for (int i = 0; i < want.length; i++) {
//             wants.put(want[i], wants.getOrDefault(want[i], 0)+number[i]);
//             if (!prods.contains(want[i])) prods.add(want[i]);
//         }

//         int ans = 0;
//         for (int i = 0; i < 10; i++) {
//             String curr = discount[i];
//             wants.put(curr, wants.getOrDefault(curr, 0)-1);
//         }

//         if (check(wants, prods)) ans++;

//         for (int i = 10; i < discount.length; i++) {
//             String curr = discount[i];
//             String prev = discount[i-10];
//             wants.put(curr, wants.getOrDefault(curr, 0)-1); // 새로 들어오는거
//             wants.put(prev, wants.getOrDefault(prev, 0)+1); // 나가는거

//             if (check(wants, prods)) ans++;
//         }

//         return ans;
//     }

//     // 반복되는 로직이 있다면 함수 분리 고려하기 (여유 될 때)
//     static boolean check(Map<String, Integer> wants, Set<String> prods) {
//         boolean valid = true;
//         for (String prod : prods) {
//             if (wants.get(prod) > 0) valid = false;
//         }

//         return valid;
//     }
// }

// 첫 풀이 (
//     중복 로직 때문에 코드가 지저분함,
//     일단 첫 10일을 돌아야 조건을 만족하는지 알 수 있는데 불필요한 로직이 반복됨
// )

// import java.util.*;

// class Solution {

//     public int solution(String[] want, int[] number, String[] discount) {
//         // number 원소들의 `합이 무조건 10`이라는 조건이 있었다!! 문제를 자세히 읽고 시작하자!! 타이핑부터 하지 말고
//         Map<String, Integer> wants = new HashMap<>();
//         Set<String> prods = new HashSet<>();
//         for (int i = 0; i < want.length; i++) {
//             wants.put(want[i], wants.getOrDefault(want[i], 0)+number[i]);
//             if (!prods.contains(want[i])) prods.add(want[i]);
//         }

//         int ans = 0;
//         for (int i = 0; i < 10; i++) {
//             String curr = discount[i];
//             wants.put(curr, wants.getOrDefault(curr, 0)-1);

//             boolean valid = true;
//             for (String prod : prods) {
//                 if (wants.get(prod) > 0) valid = false;
//             }

//             if (valid) ans++;
//         }
//         for (int i = 10; i < discount.length; i++) {
//             String curr = discount[i];
//             String prev = discount[i-10];
//             wants.put(curr, wants.getOrDefault(curr, 0)-1); // 새로 들어오는거
//             wants.put(prev, wants.getOrDefault(prev, 0)+1); // 나가는거

//             boolean valid = true;
//             for (String prod : prods) {
//                 if (wants.get(prod) > 0) valid = false;
//             }

//             if (valid) ans++;
//         }

//         return ans;
//     }
// }
