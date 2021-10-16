package p0055;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public boolean canJump(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            Integer front = q.poll();
            if (front >= nums.length) {
                break;
            }
            for (int i = 1; i <= nums[front]; i++) {
                if (!visited.contains(front + i)) {
                    visited.add(front + i);
                    q.add(front + i);
                }
            }
        }
        if (visited.contains(nums.length - 1)) {
            return true;
        }
        return false;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(solution.canJump(nums));
    }
}