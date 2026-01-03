import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int maximum = -1;
        double sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > maximum) {
                maximum = arr[i];
            }
            sum += arr[i];
        }

        bw.write(String.valueOf(sum / N / maximum * 100));
        // `val + ""` 는 `new StringBuilder().append(val).append("")`로 컴파일되므로 객체 생성 오버헤드가 생긴다!!
        // `String.valueOf(val)` 는 적절한 타입의 `toString()` 메서드를 바로 호출해주기 때문에 효율적이다

        bw.flush();
        bw.close();
        br.close();
    }
}
