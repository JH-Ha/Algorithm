package p0003;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<String, Integer> visitedPos = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer lastPos = visitedPos.get(Character.toString(s.charAt(i)));
            if (lastPos != null) {
                ans = Math.max(visitedPos.size(), ans);
                visitedPos = new HashMap<>();
                for (int j = lastPos + 1; j < i; j++) {
                    visitedPos.put(Character.toString(s.charAt(j)), j);
                }
            }
            visitedPos.put(Character.toString(s.charAt(i)), i);
        }
        ans = Math.max(visitedPos.size(), ans);
        return ans;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
}
