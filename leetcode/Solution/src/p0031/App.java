package p0031;

class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        while (i > 0) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
            i--;
        }
        if (i != 0) {
            int j = n - 1;
            while (j > 0) {
                if (nums[j] > nums[i - 1]) {
                    break;
                }
                j--;
            }
            swap(nums, i - 1, j);
        }
        // reverse
        for (int k = i; k < i + (n - i) / 2; k++) {
            swap(nums, k, n - 1 - (k - i));
        }
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 3, 2 };
        solution.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
