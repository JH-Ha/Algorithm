package p0020;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    result = false;
                    break;
                }
                Character popC = stack.pop();
                if ((c == ')' && popC != '(')) {
                    result = false;
                    break;
                } else if (c == '}' && popC != '{') {
                    result = false;
                    break;
                } else if (c == ']' && popC != '[') {
                    result = false;
                    break;
                }
            }
        }
        if (stack.size() != 0) {
            result = false;
        }
        return result;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "([)]";
        System.out.println(solution.isValid(s));
    }
}
