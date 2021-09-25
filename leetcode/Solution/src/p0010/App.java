package p0010;

class Solution {
    public boolean isMatch(String s, String p) {
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

        // System.out.println(solution.isMatch("mississippi", "mis*is*ip*."));
        // System.out.println(solution.isMatch("a", "abb"));
        // System.out.println(solution.isMatch("ab", ".*c"));
        // System.out.println(solution.isMatch("bbbba", ".*a*a"));
        System.out.println(solution.isMatch("ab", ".*.."));

    }
}
