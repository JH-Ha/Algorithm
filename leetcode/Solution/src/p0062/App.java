package p0062;

class Solution {
    public int uniquePaths(int m, int n) {
        m = m - 1;
        n = n - 1;
        long answer = 1;
        long up = 1;
        long leftBottom = 1;
        long rightBottom = 1;

        while (up <= (m + n) || leftBottom <= m || rightBottom <= n) {
            if (up <= (m + n)) {
                answer *= up;
                up++;
            }
            if (leftBottom <= m && answer % leftBottom == 0) {
                answer /= leftBottom;
                leftBottom++;
            }
            if (rightBottom <= n && answer % rightBottom == 0) {
                answer /= rightBottom;
                rightBottom++;
            }
        }
        return (int) answer;
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 2));
    }
}
