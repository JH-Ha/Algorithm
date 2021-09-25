package p0005;

class Solution {
    public int checkPalindrome(int[][] dp, int start, int end, String s) {
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int len = end - start + 1;
        if (len <= 1) {
            dp[start][end] = 1;
        } else if (s.charAt(end) == s.charAt(start)) {
            dp[start][end] = checkPalindrome(dp, start + 1, end - 1, s);
        } else {
            dp[start][end] = -1;
        }
        return dp[start][end];
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxLen = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int len = j - i + 1;
                if (len > maxLen && checkPalindrome(dp, i, j, s) == 1) {
                    maxLen = len;
                    start = i;
                    end = j + 1;
                }
            }
        }
        return s.substring(start, end);
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "babad";
        System.out.println(solution.longestPalindrome(s));
    }
}
