import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();
        String s = br.readLine();

        for (int len = 1; len <= s.length(); len++) {
            for (int idx = 0; idx+len <= s.length(); idx++) {
                set.add(s.substring(idx, idx+len));
            }
        }

        System.out.println(set.size());
    }
}
