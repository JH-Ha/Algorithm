package p3243;

import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            s.add(i);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            int lb = s.ceiling(from + 1);
            int ub = s.floor(to - 1);
            for (int j = lb; j <= ub; j++) {
                s.remove(j);
            }
            ans[i] = s.size() - 1;
        }
        return ans;
    }
}