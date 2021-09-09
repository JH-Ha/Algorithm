package weeklyChallenge2021.fifthWeek;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    static List<String> vowels = List.of("A", "E", "I", "O", "U");
    static Integer orderNum = 0;
    static Map<String, Integer> orderMap = new HashMap<>();
    static {
        initOrderMap(orderMap, new LinkedList<>());
    }

    public static void initOrderMap(Map<String, Integer> orderMap, List<String> vowelList) {
        String joinWord = String.join("", vowelList);
        if (joinWord.length() != 0) {
            orderMap.put(joinWord, orderNum);
        }
        if (vowelList.size() <= 4) {
            for (int i = 0; i < vowels.size(); i++) {
                orderNum = orderNum + 1;
                vowelList.add(vowels.get(i));
                initOrderMap(orderMap, vowelList);
                vowelList.remove(vowelList.size() - 1);
            }
        }
    }

    public int solution(String word) {
        return orderMap.get(word);
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "I";
        System.out.println(solution.solution(word));
    }
}