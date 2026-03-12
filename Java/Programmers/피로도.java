import java.util.*;

class Solution {

    int[][] dungeons;
    boolean[] vst;
    int ans;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        vst = new boolean[dungeons.length];

        for (int i = 0; i < dungeons.length; i++) {
            search(i, k, 0);
        }

        return ans;
    }

    void search(int idx, int curr, int cnt) {
        if (vst[idx]) return;

        if (curr >= dungeons[idx][0]) {
            ans = Math.max(ans, cnt+1);
            vst[idx] = true;

            for (int i = 0; i < dungeons.length; i++) {
                if (vst[i]) continue;

                search(i, curr-dungeons[idx][1], cnt+1);
            }

            vst[idx] = false;
        }
    }
}
