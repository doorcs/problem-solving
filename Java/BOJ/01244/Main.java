import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int cnt = Integer.parseInt(br.readLine());
        int[] switches = new int[cnt+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= cnt; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) { // 인덱스 활용하지 않는 for문을 while로 대체
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int i = val; i <= cnt; i += val) { // 불필요한 변수 빼고 for문의 증감식 활용
                    switches[i] = switches[i] == 1 ? 0 : 1;
                }
            } else { // == 2
                int fr = val-1;
                int rr = val+1;
                while (fr >= 1 && rr <= cnt && switches[fr] == switches[rr]) {
                    fr--;
                    rr++;
                }
                for (int i = fr+1; i < rr; i++) {
                    switches[i] = switches[i] == 1 ? 0 : 1;
                }
            }
        }

        for (int i = 1; i <= cnt; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) { // 불필요한 변수를 빼고 반복문 인덱스 활용
                System.out.println();
            }
        }
    }
}

// 첫 풀이

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     public static void main(String[] args) throws IOException {
//         int cnt = Integer.parseInt(br.readLine());
//         int[] switches = new int[cnt+1];
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         for (int i = 1; i <= cnt; i++) {
//             switches[i] = Integer.parseInt(st.nextToken());
//         }

//         int N = Integer.parseInt(br.readLine());
//         for (int i = 0; i < N; i++) {
//             st = new StringTokenizer(br.readLine());
//             int gender = Integer.parseInt(st.nextToken());
//             int val = Integer.parseInt(st.nextToken());

//             if (gender == 1) {
//                 int diff = val;
//                 while (val <= cnt) {
//                     switches[val] = switches[val] == 1 ? 0 : 1;
//                     val += diff;
//                 }
//             } else { // == 2
//                 int fr = val-1;
//                 int rr = val+1;
//                 while (fr >= 1 && rr <= cnt && switches[fr] == switches[rr]) {
//                     fr--;
//                     rr++;
//                 }
//                 for (int j = fr+1; j < rr; j++) {
//                     switches[j] = switches[j] == 1 ? 0 : 1;
//                 }
//             }
//         }

//         int out = 0;
//         for (int i = 1; i <= cnt; i++) {
//             System.out.print(switches[i] + " ");
//             if (++out % 20 == 0) {
//                 System.out.println();
//             }
//         }
//     }
// }
