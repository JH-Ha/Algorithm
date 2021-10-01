package p0033;

class Solution {
    public int search(int[] nums, int target) {
        int first = nums[0];
        int n = nums.length;
        int l = 1;
        int r = n - 1;
        int turnPoint = 0;
        int answer = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= first) {
                turnPoint = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        l = turnPoint;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                answer = mid;
                break;
            }
        }

        l = 0;
        r = turnPoint - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                answer = mid;
                break;
            }
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 3, 1 };
        int target = 3;
        System.out.println(solution.search(nums, target));
    }
}
