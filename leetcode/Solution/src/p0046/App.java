package p0046;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void solve(List<List<Integer>> answer, int[] nums, List<Integer> cur) {
        if (cur.size() == nums.length) {
            answer.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (cur.contains(num)) {
                continue;
            }
            cur.add(num);
            solve(answer, nums, cur);
            cur.remove((Integer) num);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        solve(answer, nums, new ArrayList<>());
        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> answer = solution.permute(nums);
        answer.stream().forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");

            });
            System.out.println();
        });
    }
}
