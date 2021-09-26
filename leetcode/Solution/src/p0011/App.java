package p0011;

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = (r - l) * Math.min(height[l], height[r]);
        while (l < r) {
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
            max = Math.max((r - l) * Math.min(height[l], height[r]), max);
        }
        return max;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = { 2, 3, 4, 5, 18, 17, 6 };
        System.out.println(solution.maxArea(height));
    }
}
