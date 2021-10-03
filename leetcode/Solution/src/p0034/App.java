package p0034;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int[] answer = { -1, -1 };
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                if (nums[mid] == target) {
                    answer[0] = mid;
                }
                r = mid - 1;
            }
        }
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                if (nums[mid] == target) {
                    answer[1] = mid;
                }
                l = mid + 1;
            }
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 6;

        int[] answer = solution.searchRange(nums, target);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
