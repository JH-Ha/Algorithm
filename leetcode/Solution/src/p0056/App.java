package p0056;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> mergeArray = new ArrayList<>();

        mergeArray.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int idx = mergeArray.size() - 1;
            int[] mergeItem = mergeArray.get(idx);
            if (intervals[i][0] <= mergeItem[1]) {
                if (intervals[i][1] > mergeItem[1]) {
                    mergeArray.get(idx)[1] = intervals[i][1];
                }
            } else {
                mergeArray.add(intervals[i]);
            }
        }

        return mergeArray.stream().map(l -> l).toArray(int[][]::new);
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] answer = solution.merge(intervals);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i][0] + " " + answer[i][1]);
        }
    }
}
