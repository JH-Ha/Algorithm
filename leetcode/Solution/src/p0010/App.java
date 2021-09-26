package p0010;

class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int j = 2; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);
                if (sChar == pChar || pChar == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    // skip matching
                    dp[i][j] = dp[i][j - 2];

                    // matching
                    char pPrevChar = p.charAt(j - 2);
                    if (pPrevChar == sChar || pPrevChar == '.') {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

    public boolean checkString(int[][] dp, String s, String p, int si, int pi) {
        if (si == s.length() && pi == p.length()) {
            return true;
        }
        if (si == s.length() && pi < p.length()) {
            return false;
        }
        if (si < s.length() && pi == p.length()) {
            return true;
        }
        if (dp[si][pi] != 0) {
            return dp[si][pi] == 1;
        }
        boolean isPossible = false;
        if (pi + 1 < p.length()) {
            // * 이 있는 경우
            if (p.charAt(pi + 1) == '*') {
                // 매칭 시키는 경우
                if ((s.charAt(si) == p.charAt(pi)) || p.charAt(pi) == '.') {
                    isPossible |= checkString(dp, s, p, si + 1, pi);
                }
                // 매칭 안시키고 넘어가는 경우
                isPossible |= checkString(dp, s, p, si, pi + 2);
            }
        }
        if ((s.charAt(si) == p.charAt(pi)) || p.charAt(pi) == '.') {
            isPossible |= checkString(dp, s, p, si + 1, pi + 1);
        }
        dp[si][pi] = isPossible ? 1 : -1;
        return isPossible;

        // if (pi == -1) {
        // return (si == -1) ? 1 : -1;
        // } else if (si == -1) {
        // return -1;
        // }
        // if (dp[si][pi] != 0) {
        // return dp[si][pi];
        // }
        // boolean isPossible = false;
        // // 매칭되는 경우
        // if ((s.charAt(si) == p.charAt(pi)) || p.charAt(pi) == '.') {
        // isPossible |= checkString(dp, s, p, si - 1, pi - 1) == 1;
        // }
        // // *이 오는 경우 올 수 있는 경우
        // else if (p.charAt(pi) == '*') {
        // // 스킵하는 경우
        // isPossible |= checkString(dp, s, p, si, pi - 2) == 1;
        // // 하나만 매칭시키는 경우
        // if ((s.charAt(si) == p.charAt(pi - 1)) || p.charAt(pi - 1) == '.') {
        // isPossible |= checkString(dp, s, p, si - 1, pi) == 1;
        // }
        // }
        // dp[si][pi] = isPossible ? 1 : -1;
        // return dp[si][pi];
    }

    public boolean isMatchSlow(String s, String p) {
        boolean isPossible = false;
        // s가 남았는데 p가 없는 경우
        if (s.length() > 0 && p.length() == 0) {
            return false;
        }
        // s와 p가 모두 소진된 경우
        else if (s.length() == 0 && p.length() == 0) {
            return true;
        }

        if (p.length() > 1) {
            // 1. 뒤에 *가 있는 경우
            if (p.charAt(1) == '*') {
                // 1.1 p가 .인 경우
                if (p.charAt(0) == '.') {
                    // p를 건너뛰는 경우
                    isPossible |= isMatch(s, p.substring(2));

                    // 매칭하고 지나가는 경우
                    if (s.length() == 0) {
                        isPossible |= false;
                    } else {
                        isPossible |= isMatch(s.substring(1), p);
                    }
                }
                // 1.2 p가 문자인경우
                else {
                    // p를 건너뛰는 경우
                    isPossible |= isMatch(s, p.substring(2));
                    // 매칭하고 지나가는 경우
                    if (s.length() == 0) {
                        isPossible |= false;
                    } else if (p.charAt(0) == s.charAt(0)) {
                        isPossible |= isMatch(s.substring(1), p);
                    }
                }
            }
            // 2. 뒤에 *가 없는 경우
            else {
                // 2.0 s의 길이가 0인 경우는 불가능 함
                if (s.length() == 0) {
                    isPossible |= false;
                }
                // 2.1 p가 .인 경우
                else if (p.charAt(0) == '.') {
                    isPossible |= isMatch(s.substring(1), p.substring(1));
                }
                // 2.2 p가 문자인경우
                else if (p.charAt(0) == s.charAt(0)) {
                    isPossible |= isMatch(s.substring(1), p.substring(1));
                }
                // 2.3 p와 s가 일치하지 않는 경우
                else {
                    isPossible |= false;
                }
            }
        }
        // p가 문자 하나밖에 안남은 경우
        else {
            // 매칭할 s가 없으면 flase
            if (s.length() == 0) {
                isPossible |= false;
            }
            // p가 . 인경우
            else if (p.charAt(0) == '.') {
                isPossible |= isMatch(s.substring(1), p.substring(1));
            }
            // p가 일치하는 경우
            else if (s.charAt(0) == p.charAt(0)) {
                isPossible |= isMatch(s.substring(1), p.substring(1));
            }
        }
        return isPossible;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("a", "a"));
        System.out.println(solution.isMatch("mississippi", "mis*is*ip*."));
        System.out.println(solution.isMatch("a", "abb"));
        System.out.println(solution.isMatch("ab", ".*c"));
        System.out.println(solution.isMatch("bbbba", ".*a*a"));
        System.out.println(solution.isMatch("ab", ".*.."));

    }
}
