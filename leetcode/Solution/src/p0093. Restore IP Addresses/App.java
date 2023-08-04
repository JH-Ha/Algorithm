package p0093;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
    void solve(List<String> ans, String s, Stack<String> cur, int pos) {
        if (cur.size() == 4) {
            if (pos == s.length()) {
                String result = cur.stream()
                        .collect(Collectors.joining("."));
                ans.add(result);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (pos + i > s.length()) {
                continue;
            }
            String numStr = s.substring(pos, pos + i);
            if (i >= 2 && numStr.startsWith("0")) {
                continue;
            }
            int num = Integer.parseInt(numStr);
            if (num > 255) {
                continue;
            }
            cur.push(numStr);
            solve(ans, s, cur, pos + i);
            cur.pop();
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        solve(ans, s, new Stack<>(), 0);
        return ans;
    }
}

public class App {
    public static void main(String[] args) {
        String s = "0000";
        new Solution().restoreIpAddresses(s);
    }
}