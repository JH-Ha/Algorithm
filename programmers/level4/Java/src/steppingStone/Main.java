package steppingStone;

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int l = 0;
        int r = distance;

        while (l <= r) {
            int mid = (r - l) / 2 + l;

            int removedRocks = 0;
            int prev = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    removedRocks++;
                } else {
                    prev = rocks[i];
                }
            }
            if (distance - prev < mid)
                removedRocks++;
            if (removedRocks <= n) {
                answer = Math.max(mid, answer);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int distance = 25;
        int[] rocks = { 2, 14, 11, 21, 17 };
        int n = 2;
        System.out.println(solution.solution(distance, rocks, n));
    }
}
