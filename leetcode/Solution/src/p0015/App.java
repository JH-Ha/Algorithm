package p0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1;
                int right = n - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    int sum = nums[i] + nums[j] + nums[mid];
                    if (sum > 0) {
                        right = mid - 1;
                    } else if (sum < 0) {
                        left = mid + 1;
                    } else {
                        List<Integer> sumSet = new ArrayList<>();
                        sumSet.add(nums[i]);
                        sumSet.add(nums[j]);
                        sumSet.add(nums[mid]);
                        answer.add(sumSet);
                        break;
                    }
                }
            }
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> list = solution.threeSum(nums);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> ll = list.get(i);
            for (int j = 0; j < ll.size(); j++) {
                System.out.println(ll.get(j));
            }
        }
    }
}
