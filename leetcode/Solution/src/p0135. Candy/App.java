package p0134;

import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        // init
        for (int i = 0; i < ratings.length; i++) {
            candies[i] = 1;
        }
        // left -> right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // right -> left
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int answer = 0;
        for (int num : candies) {
            answer += num;
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1 };
        System.out.println(solution.longestConsecutive(nums));
    }
}
