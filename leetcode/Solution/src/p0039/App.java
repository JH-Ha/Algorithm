package p0039;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < candidates.length; j++) {
                int idx = i - candidates[j];
                // 후보 숫자와 전에 있는 숫자들과 더해서 i 가 되는 경우
                if (idx >= 0) {
                    List<List<Integer>> beforeList = map.get(idx);
                    if (beforeList != null) {
                        List<List<Integer>> curList = map.getOrDefault(i, new ArrayList<>());
                        for (int k = 0; k < beforeList.size(); k++) {
                            List<Integer> list = new ArrayList<>();
                            list.addAll(beforeList.get(k));
                            // 중복을 피하고 오름차순으로 후보군을 만들기 위함이다.
                            if (candidates[j] >= list.get(list.size() - 1)) {
                                list.add(candidates[j]);
                                curList.add(list);
                            }
                        }
                        if (!curList.isEmpty())
                            map.put(i, curList);
                    }
                }
                // 후보 숫자가 바로 i 가 되는 경우
                if (i == candidates[j]) {
                    List<List<Integer>> curList = map.get(candidates[j]);
                    if (curList == null) {
                        curList = new ArrayList<>();
                    }
                    List<Integer> item = new ArrayList<>();
                    item.add(candidates[j]);
                    curList.add(item);
                    map.put(candidates[j], curList);
                }
            }
        }
        return map.getOrDefault(target, new ArrayList<>());
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = { 2, 3, 5 };
        int target = 8;
        List<List<Integer>> answer = solution.combinationSum(candidates, target);
        for (int i = 0; i < answer.size(); i++) {
            List<Integer> list = answer.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.println(list.get(j));
            }
            System.out.println();
        }
    }
}
