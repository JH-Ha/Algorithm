package p0096;

class Solution {
    int[] dp = new int[20];
    {
        for (int i = 0; i < 20; i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
    }

    public int numTrees(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += numTrees(i) * numTrees(n - 1 - i);
        }
        dp[n] = num;
        return dp[n];
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }
}