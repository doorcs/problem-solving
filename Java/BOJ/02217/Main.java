import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N]; // Comparator를 넣어서 역순으로 정렬해주기 위해 Integer 배열 사용

        for (int i = 0; i < N; i++) {
            int curr = Integer.parseInt(br.readLine());
            arr[i] = curr;
        }
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o2, o1));

        int maximum = 0;
        for (int i = 0; i < arr.length; i++) {
            // int curr = arr[i];
            // if (curr * (i+1) > maximum) {
            //     maximum = curr * (i+1);
            // }
            maximum = Math.max(arr[i] * (i+1), maximum); // Math.min(), Math.max() 잘 활용하기
        }

        System.out.println(maximum);
    }
}

// 첫 접근 (오답)

// import java.io.*;
// import java.util.*;

// public class Main {

//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     public static void main(String[] args) throws IOException {
//         int N = Integer.parseInt(br.readLine());
//         Integer[] arr = new Integer[N];

//         for (int i = 0; i < N; i++) {
//             int curr = Integer.parseInt(br.readLine());
//             arr[i] = curr;
//         }
//         Arrays.sort(arr, (o1, o2) -> Integer.compare(o2, o1));

//         int cnt = 1;
//         int val = arr[0];
//         for (int i = 1; i < arr.length; i++) {
//             int curr = arr[i];
//             if (curr * (cnt+1) > cnt * val) {
//                 cnt++;
//                 val = curr;
//             }
//         }

//         System.out.println(cnt * val);
//     }
// }
