package p3160;

import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ans = new int[queries.length];
        Map<Integer, Set<Integer>> map = new HashMap<>(); // color -> posSet
        Map<Integer, Integer> colorMap = new HashMap<>(); // pos -> color
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            Integer prevColor = colorMap.get(query[0]);
            colorMap.put(query[0], query[1]);
            if (prevColor == null) {
                Set<Integer> posSet = map.get(query[1]);
                if (posSet == null) {
                    Set<Integer> set = new HashSet<>();
                    set.add(query[0]);
                    map.put(query[1], set);
                } else {
                    posSet.add(query[0]);
                }
            } else {
                Set<Integer> prevPosSet = map.get(prevColor);

                if (prevPosSet != null) {
                    prevPosSet.remove(query[0]);
                    if (prevPosSet.isEmpty()) {
                        map.remove(prevColor);
                    }
                }

                Set<Integer> posSet = map.get(query[1]);
                if (posSet == null) {
                    Set<Integer> set = new HashSet<>();
                    set.add(query[0]);
                    map.put(query[1], set);
                } else {
                    posSet.add(query[0]);
                }
            }
            ans[i] = map.size();
        }
        return ans;
    }
}