package p0091;

class Solution {
    int[] dp = new int[110];

    public Solution() {
        for (int i = 0; i < 110; i++) {
            dp[i] = -1;
        }
    }

    public int numDecodings(String s) {
        if (dp[s.length()] != -1) {
            return dp[s.length()];
        }
        if (s.length() == 1) {
            int first = s.charAt(0) - '0';
            if (first == 0)
                return 0;
            else
                return 1;
        } else if (s.length() == 0) {
            return 1;
        }
        int first = s.charAt(0) - '0';
        int second = s.charAt(1) - '0';
        int num = first * 10 + second;
        if (first == 0) {
            dp[s.length()] = 0;
        } else if (num >= 27) {
            dp[s.length()] = numDecodings(s.substring(1, s.length()));
        } else {
            dp[s.length()] = numDecodings(s.substring(1, s.length()))
                    + numDecodings(s.substring(2, s.length()));
        }
        return dp[s.length()];
    }
}

public class App {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2)));
        new Solution().deleteDuplicates(head);
    }
}