package p3158;

import java.util.*;

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {

                answer = answer ^ num;
            }
            set.add(num);
        }

        return answer;
    }
}