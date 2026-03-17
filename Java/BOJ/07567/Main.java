import java.io.*;

public class Main {

    static char[] arr;

    public static void main(String[] args) {
        arr = readLine().toCharArray();

        int ans = 10;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] != arr[i]) ans += 10; // 이전 그릇이랑 다른 모양이면 포개지지 않으니 +10
            else ans += 5; // 같은 모양이면 포개지니 +5
        }

        System.out.println(ans);
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
