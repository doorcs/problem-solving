import java.util.*;

class Solution {

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5; // cacheSize가 0일 경우 전부 캐시 미스

        Map<String, Integer> mp = new HashMap<>();
        int totalTime = 0;
        for (int i = 0; i < cities.length; i++) {
            String curr = cities[i].toLowerCase();

            if (mp.containsKey(curr)) { // 현재 캐시에 있을 경우
                totalTime++;

                mp.put(curr, totalTime);
                continue;
            } else { // 캐시에 없을 경우
                totalTime += 5;

                if (mp.size() < cacheSize) { // 캐시 공간에 여유가 있을 경우
                    mp.put(curr, totalTime);
                } else { // 기존 캐시를 지워야 하는 경우
                    int diff = 0;
                    String rmName = "";
                    for (var e : mp.entrySet()) {
                        if (totalTime - e.getValue() > diff) {
                            diff = totalTime - e.getValue(); // diff가 크다 == 마지막 hit가 totalTime으로부터 오래 전이다
                            rmName = e.getKey();
                        }
                    }
                    mp.remove(rmName);
                    mp.put(curr, totalTime);
                }
            }
        }

        return totalTime;
    }
}
