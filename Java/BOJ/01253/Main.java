import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .sorted()
                          .toArray(); // 스트림 활용
        int ans = 0;

        for (int i = 0; i < N; i++) {
            int fr = 0;
            int rr = N-1;
            while (fr < rr) {
                if (fr == i) {
                    fr++;
                    continue;
                }
                if (rr == i) {
                    rr--;
                    continue;
                }
                if (arr[fr] + arr[rr] == arr[i]) {
                    ans++;
                    break;
                } else if (arr[fr] + arr[rr] < arr[i]) {
                    fr++;
                } else {
                    rr--;
                }
            }
        }

        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();
    }
}

// StringTokenizer st = new StringTokenizer(br.readLine());
// int[] arr = new int[N];
// for (int i = 0; i < N; i++) {
//     arr[i] = Integer.parseInt(st.nextToken());
// }
// Arrays.sort(arr);
