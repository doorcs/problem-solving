import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int fr = 0;
        int rr = N-1;
        int ans = 0;

        int[] arr = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .sorted()
                          .toArray(); // 확실히 가독성이 좋긴 한데, 20ms 정도 스트림 오버헤드가 있다

        while (fr < rr) {
            int sum = arr[fr] + arr[rr];
            if (sum == M) {
                ans++;
                fr++;
            } else if (sum < M) {
                fr++;
            } else {
                rr--;
            }
        }

        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();
    }
}

/* 스트림 없이 구현하려면:

StringTokenizer st = new StringTokenizer(br.readLine());
int[] arr = new int[N];
for (int i = 0; i < N; i++) {
    arr[i] = Integer.parseInt(st.nextToken());
}
Arrays.sort(arr);

*/
