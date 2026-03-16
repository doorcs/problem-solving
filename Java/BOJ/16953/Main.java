import java.io.*;
import java.util.*;

public class Main {

    static long A;
    static long B;

    public static void main(String[] args) {
        var st = new StringTokenizer(readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        int ansCnt = 1;
        while (B > A) {
            if (B%10 == 1) { // `*2`보다 `*10 + 1`이 무조건 크게 증가시키니까, 그리디하게 접근할 수 있다
                B/=10;
            } else if (B%2 == 0) {
                B/=2;
            } else {
                break; // 둘 다 안되는 경우
            }
            ansCnt++;
        }

        if (B != A) System.out.println(-1);
        else System.out.println(ansCnt);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

// BFS 기반 풀이 (꼭 그래프가 있어야만 탐색이 가능한 게 아니라는 점 기억하기!!)

// import java.io.*;
// import java.util.*;

// public class Main {

//     static long A;
//     static long B;

//     public static void main(String[] args) {
//         var st = new StringTokenizer(readLine());
//         A = Long.parseLong(st.nextToken());
//         B = Long.parseLong(st.nextToken());

//         Queue<Node> q = new ArrayDeque<>();
//         q.add(new Node(A, 1)); // 연산 횟수를 기준으로 하는 너비 우선 탐색 (BFS)
//         while (!q.isEmpty()) {
//             Node curr = q.remove();
//             if (curr.val > B) {
//                 continue;
//             } else if (curr.val == B) {
//                 System.out.println(curr.cnt);
//                 return;
//             } else {
//                 q.add(new Node(curr.val*2, curr.cnt+1));
//                 q.add(new Node((curr.val*10)+1, curr.cnt+1)); // 꼭 그래프가 있어야만 탐색이 아니다
//             }
//         }

//         System.out.println(-1);
//     }

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     static String readLine() {
//         try {
//             return br.readLine();
//         } catch (IOException e) {
//             throw new RuntimeException(e);
//         }
//     }
// }

// class Node {

//     long val;
//     long cnt;

//     Node(long val, long cnt) {
//         this.val = val;
//         this.cnt = cnt;
//     }
// }
