package p0022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public Map<Integer, List<String>> dp = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if (dp.get(n) != null) {
            return dp.get(n);
        }
        if (n == 1) {
            List<String> list = new ArrayList<>();
            list.add("()");
            dp.put(1, list);
            return list;
        }
        List<String> answer = new ArrayList<>();
        List<String> smallerOne = generateParenthesis(n - 1);

        Set<String> checked = new HashSet<>();
        for (int i = 0; i < smallerOne.size(); i++) {
            answer.add("(" + smallerOne.get(i) + ")");
        }
        for (int i = 1; i < n; i++) {
            List<String> left = generateParenthesis(i);
            List<String> right = generateParenthesis(n - i);
            for (int x = 0; x < left.size(); x++) {
                for (int y = 0; y < right.size(); y++) {
                    String newStr = left.get(x) + right.get(y);
                    if (!checked.contains(newStr)) {
                        checked.add(newStr);
                        answer.add(newStr);
                    }
                }
            }
        }
        dp.put(n, answer);
        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3).stream().forEach(a -> {
            System.out.println(a);
        });
    }
}
