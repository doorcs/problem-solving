import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int ans = 0;

        for (int i = 0; i < P; i++) {
            char curr = arr[i];
            if (curr == 'A') {
                A--;
            } else if (curr == 'C') {
                C--;
            } else if (curr == 'G') {
                G--;
            } else {
                T--;
            }
        }
        if (A < 1 && C < 1 && G < 1 && T < 1) {
            ans++;
        }

        for (int i = P; i < S; i++) {
            char fr = arr[i-P];
            char rr = arr[i];
            if (fr == 'A') {
                A++;
            } else if (fr == 'C') {
                C++;
            } else if (fr == 'G') {
                G++;
            } else {
                T++;
            } // 문자열에서 나가는 문자 처리
            if (rr == 'A') {
                A--;
            } else if (rr == 'C') {
                C--;
            } else if (rr == 'G') {
                G--;
            } else {
                T--;
            } // 문자열에 새로 들어오는 문자 처리

            if (A < 1 && C < 1 && G < 1 && T < 1) {
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
