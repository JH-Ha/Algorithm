package p3152;

import java.util.*;

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        TreeSet<Integer> posSet = new TreeSet<>();

        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev % 2 == nums[i] % 2) {
                posSet.add(i - 1);
            }
            prev = nums[i];
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            Integer right = posSet.ceiling(query[0]);
            Integer left = posSet.floor(query[1] - 1);
            // System.out.println("query " + query[0] + ',' + query[1]);
            if (query[0] == query[1]) {
                ans[i] = true;
            } else if (right == null || left == null) {
                ans[i] = true;
            } else if (right <= query[1] - 1 || left >= query[0]) {
                // System.out.println("left : " + left + " right : " + right);
                ans[i] = false;
            } else {
                ans[i] = true;
            }
        }
        return ans;
    }
}