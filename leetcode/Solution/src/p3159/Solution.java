package p3159;

import java.util.*;

class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (x == num) {
                map.put(idx + 1, i);
                idx++;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            ans[i] = map.getOrDefault(query, -1);
        }
        return ans;
    }
}