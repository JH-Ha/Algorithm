package p0128;

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(nums[i])) {
                int cnt = 1;
                for (int x = nums[i] - 1; x > Integer.MIN_VALUE; x--) {
                    if (set.contains(x)) {
                        visited.add(x);
                        cnt++;
                    } else {
                        break;
                    }
                }
                for (int y = nums[i] + 1; y < Integer.MAX_VALUE; y++) {
                    if (set.contains(y)) {
                        visited.add(y);
                        cnt++;
                    } else {
                        break;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(solution.longestConsecutive(nums));
    }
}
