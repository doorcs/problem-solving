import java.io.*;
import java.util.*;

public class Main {

    static int K;
    static int N;

    public static void main(String[] args) {
        var st = new StringTokenizer(readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        List<Node> li = new ArrayList<>();

        while (N-- > 0) {
            st = new StringTokenizer(readLine());
            li.add(new Node(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())));
        }

        Collections.sort(li, (a, b) -> {
            if (b.gold == a.gold && b.silver == a.silver) {
                return b.bronze - a.bronze;
            } else if (b.gold == a.gold) {
                return b.silver - a.silver;
            }

            return b.gold - a.gold;
        });

        if (li.get(0).country == K) {
            System.out.println(1);
            return;
        }

        int rank = 1;
        int prevGold = li.get(0).gold;
        int prevSilver = li.get(0).silver;
        int prevBronze = li.get(0).bronze;
        for (int i = 1; i < li.size(); i++) {
            Node curr = li.get(i);
            if (curr.gold != prevGold || curr.silver != prevSilver || curr.bronze != prevBronze) {
                rank = i+1; // 1 2 2 4 5
                prevGold = curr.gold;
                prevSilver = curr.silver;
                prevBronze = curr.bronze;
            }

            if (curr.country == K) {
                System.out.println(rank);
                return;
            }
        }
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

class Node {

    int country;
    int gold;
    int silver;
    int bronze;

    Node(int country, int gold, int silver, int bronze) {
        this.country = country;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
}
