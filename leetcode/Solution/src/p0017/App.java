package p0017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, List<String>> map = new HashMap<>();
    {
        map.put("2", List.of("a", "b", "c"));
        map.put("3", List.of("d", "e", "f"));
        map.put("4", List.of("g", "h", "i"));
        map.put("5", List.of("j", "k", "l"));
        map.put("6", List.of("m", "n", "o"));
        map.put("7", List.of("p", "q", "r", "s"));
        map.put("8", List.of("t", "u", "v"));
        map.put("9", List.of("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits.length() == 0) {
            return answer;
        } else if (digits.length() == 1) {
            return map.get(digits);
        }
        String digit = digits.substring(0, 1);
        List<String> str = this.map.get(digit);
        List<String> rightStr = letterCombinations(digits.substring(1));
        for (int i = 0; i < str.size(); i++) {
            String s = str.get(i);
            for (int j = 0; j < rightStr.size(); j++) {
                String rs = rightStr.get(j);
                answer.add(s + rs);
            }
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "23";
        List<String> ans = solution.letterCombinations(digits);

        ans.stream().forEach(a -> {
            System.out.println(a);
        });
    }
}
