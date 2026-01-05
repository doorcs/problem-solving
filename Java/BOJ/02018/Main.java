import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int fr = 1;
        int rr = 1;
        int ans = 0;
        long sum = 1;

        while (rr < N) {
            if (sum == N) {
                ans++;
                rr++;
                sum += rr;
            } else if (sum < N) {
                rr++;
                sum += rr;
            } else {
                sum -= fr;
                fr++;
            }
        }
        bw.write(String.valueOf(ans+1)); // 자기 자신을 선택하는 경우 (+1)

        bw.flush();
        bw.close();
        br.close();
    }
}
