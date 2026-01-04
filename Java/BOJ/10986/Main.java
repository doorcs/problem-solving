import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] psum = new long[N+1];
        long[] rem = new long[M];
        long ans = 0L;

        for (int i = 1; i <= N; i++) {
            psum[i] = psum[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            psum[i] %= M;
            if (psum[i] == 0) {
                ans++;
            }
            rem[(int)psum[i]]++; // 자바에서는 인덱스가 반드시 int 타입이어야 한다!!!!!!!!
        }

        for (int i = 0; i < M; i++) {
            if (rem[i] > 1) {
                ans += (rem[i] * (rem[i]-1) / 2);
            }
        }
        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();
    }
}

// 값 자체는 int형 범위 안에 들어온다고 해도, 자바에서 long 타입은 인덱스에 활용할 수 없다
// 반드시 (int)를 통해 int 타입으로 캐스팅해줘야 함!
