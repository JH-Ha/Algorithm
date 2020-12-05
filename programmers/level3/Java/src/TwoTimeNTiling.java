class Solution {
    public int solution(int n) {

        long[] dp = new long[n + 10];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return (int) dp[n];
    }
}

public class TwoTimeNTiling {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }
}
