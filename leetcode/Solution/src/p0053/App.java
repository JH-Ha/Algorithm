package p0053;

class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i] + currentSum, nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;

    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // int[] nums = { -1 };
        // int[] nums = { 5, 4, -1, 7, 8 };
        int[] nums = { -1, 2 };
        System.out.println(solution.maxSubArray(nums));
    }
}
