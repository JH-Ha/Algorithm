package p0045;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Node {
    int pos;
    int cnt;

    public Node(int pos, int cnt) {
        this.pos = pos;
        this.cnt = cnt;
    }
}

class Solution {
    public int jump(int[] nums) {
        Queue<Node> q = new LinkedList<>();
        int n = nums.length;
        q.add(new Node(0, 0));
        Set<Integer> visited = new HashSet<>();
        int answer = n;
        while (!q.isEmpty()) {
            Node top = q.poll();
            if (top.pos == n - 1) {
                answer = top.cnt;
                break;
            }
            for (int i = 1; i <= nums[top.pos]; i++) {
                int nx = top.pos + i;
                if (nx < n && !visited.contains(nx)) {
                    visited.add(nx);
                    q.add(new Node(nx, top.cnt + 1));
                }
            }
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(solution.jump(nums));
    }
}
