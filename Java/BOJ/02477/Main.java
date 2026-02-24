import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int lrMax = 0;
        int udMax = 0;
        int lrMaxIdx = 0;
        int udMaxIdx = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;

            if (dir <= 2) { // 동서
                if (val > lrMax) {
                    lrMax = val;
                    lrMaxIdx = i;
                }
            } else { // 남북
                if (val > udMax) {
                    udMax = val;
                    udMaxIdx = i;
                }
            }
        }

        System.out.println(K * (lrMax * udMax - arr[(lrMaxIdx + 3) % 6] * arr[(udMaxIdx + 3) % 6]));
    }
}
