import java.io.*;
import java.util.*;

public class Main {

    static int INF = (int) 1e9;

    static int N;
    static int[][] W = new int[20][20];
    static int[][] dist = new int[20][100001];

    public static void main(String[] args) {
        N = Integer.parseInt(readLine());

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1));
    }

    static int tsp(int c, int v) {
        if (v == (1 << N) - 1) {
            return W[c][0] == 0 ? INF : W[c][0];
        }

        if (dist[c][v] != -1) {
            return dist[c][v];
        }

        int min = INF;
        for (int i = 0; i < N; i++) {
            if ((v & (1 << i)) == 0 && W[c][i] != 0) {
                int next = tsp(i, v | (1 << i));
                if (next != INF) {
                    min = Math.min(min, next + W[c][i]);
                }
            }
        }

        dist[c][v] = min;
        return dist[c][v];
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
