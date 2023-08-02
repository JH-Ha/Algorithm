package p0128;

import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num >> i) & 1;
            }
            ans += (cnt % 3) << i;
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
