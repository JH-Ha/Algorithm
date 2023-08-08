package p0134;

import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        for(int i = 0; i < gas.length; i ++){
            gasSum += gas[i];
        }
        int costSum = 0;
        for(int i = 0; i < cost.length; i ++){
            costSum += cost[i];
        }
        if(costSum > gasSum){
            return -1;
        }
        int pos = 0;
        int sum = 0;
        int cnt = 0;
        int i = 0;
        while(cnt < gas.length){
            if(sum < 0){
                pos = i;
                cnt = 0;
                sum = 0;
            }
            sum += gas[i] - cost[i];
            cnt ++;
            i = (i + 1) % gas.length;
        }
        return pos;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(solution.longestConsecutive(nums));
    }
}
