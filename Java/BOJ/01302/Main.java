import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            mp.put(s, mp.getOrDefault(s, 0)+1);
        }

        int maximum = 0;
        String ans = "";
        for (var it : mp.entrySet()) {
            int curr = it.getValue();
            if (curr > maximum || curr == maximum && ans.compareTo(it.getKey()) > 0) {
                // compareTo는 호출한 객체에서 파라미터로 받은 객체를 뺀다.

                // 빼서 양수다? <- 순서가 바뀐 상태다 (호출한 객체가 파라미터로 받은 객체보다 크다)

                // Integer.valueOf(2).compareTo(Integer.valueOf(1)) <- 양수(1)
                // Integer.valueOf(1).compareTo(Integer.valueOf(2)) <- 음수(-1)

                // "b".compareTo("a") <- 양수(1)
                // "a".compareTo("b") <- 음수(-1)
                maximum = curr;
                ans = it.getKey();
            }
        }

        System.out.println(ans);
    }
}

// 첫 풀이

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     public static void main(String[] args) throws IOException {
//         int N = Integer.parseInt(br.readLine());
//         Map<String, Integer> mp = new HashMap<>();

//         for (int i = 0; i < N; i++) {
//             String s = br.readLine();
//             mp.put(s, mp.getOrDefault(s, 0)+1);
//         }

//         int maximum = 0;
//         for (var it : mp.entrySet()) {
//             int curr = it.getValue();
//             if (curr > maximum) {
//                 maximum = curr;
//             }
//         }

//         List<String> ans = new ArrayList<>();
//         for (var it : mp.entrySet()) {
//             if (it.getValue() == maximum) ans.add(it.getKey());
//         }
//         Collections.sort(ans);

//         System.out.println(ans.get(0));
//     }
// }
