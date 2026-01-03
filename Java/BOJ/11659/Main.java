import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] psum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            psum[i] = psum[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(psum[b] - psum[a-1]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

/*
 * bw.write(val + "\n");
 *
 * bw.write(String.valueOf(val) + "\n");
 *
 * bw.write(val + "");
 * bw.newLine();
 *
 * sb.append(val).append('\n');
 * bw.write(sb.toString());
 *
 * 다양하게 비교해봤는데, 아래 방식이 제일 빠르다:
 *
 * bw.write(String.valueOf(val));
 * bw.newLine();
 */
