package p100310;

class Solution {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev % 2 == nums[i] % 2) {
                return false;
            }
            prev = nums[i];
        }
        return true;
    }
}