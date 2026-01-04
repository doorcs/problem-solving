import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] psum = new int[N+1][N+1];
        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                psum[y][x] = psum[y-1][x] + psum[y][x-1] - psum[y-1][x-1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()); // 개인적으로 열은 Y, 행이 X인게 편한데
            int x1 = Integer.parseInt(st.nextToken()); // 이렇게 문제에서 명시적으로 열이 X라고 주는 경우도 있으니
            int y2 = Integer.parseInt(st.nextToken()); // 문제 조건을 잘 읽고, 필요하다면 적절하게 뒤집어서 처리하기!!
            int x2 = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(psum[y2][x2] - psum[y1-1][x2] - psum[y2][x1-1] + psum[y1-1][x1-1]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
