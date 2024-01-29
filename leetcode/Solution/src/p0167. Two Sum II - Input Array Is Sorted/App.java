package p0167;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int ans[] = new int[2];
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                break;
            } else if (sum < target) {
                l = l + 1;
            } else {
                r = r - 1;
            }
        }
        return ans;
    }
}

public class App {
    public static void main(String[] args) {

    }
}
