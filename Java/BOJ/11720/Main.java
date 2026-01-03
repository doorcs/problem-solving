import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        s = br.readLine();
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += s.charAt(i) - '0'; // Integer.parseInt()는 파라미터로 String만 받을 수 있다
        }

        bw.write(ans + ""); // BufferedWriter는 String만 출력할 수 있다. String이 아닌걸 출력하려면 `+ ""` 구문을 활용하기!
        bw.flush();
        bw.close();
        br.close();
    }
}
