package p100482;

import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        long[] longNums = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            longNums[i] = nums[i];
        }

        int answer = 1;

        // case no.1. don't change the target number
        int i = 0;
        int sameNumCnt = 1;
        while (i < longNums.length) {
            if (i + 1 < longNums.length) {
                if (longNums[i] == longNums[i + 1]) {
                    sameNumCnt++;
                    i++;
                    continue;
                }
            }

            long lowNum = longNums[i] - k;
            int l = 0;
            int r = longNums.length - 1;
            int lowPos = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (longNums[mid] == lowNum) {
                    lowPos = mid;
                    r = mid - 1;
                } else if (longNums[mid] > lowNum) {
                    lowPos = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            long upperNum = longNums[i] + k;
            l = 0;
            r = longNums.length - 1;
            int upperPos = longNums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (longNums[mid] == upperNum) {
                    upperPos = mid;
                    l = mid + 1;
                } else if (longNums[mid] > upperNum) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                    upperPos = mid;
                }
            }

            int diffNumCnt = upperPos - lowPos + 1 - sameNumCnt;
            int changedNumCnt = Math.min(diffNumCnt, numOperations);
            answer = Math.max(answer, changedNumCnt + sameNumCnt);

            i++;
            sameNumCnt = 1;
        }

        // case no.2 change every number
        for (i = 0; i < longNums.length; i++) {
            long upperNum = longNums[i] + 2 * k;
            int l = 0;
            int r = longNums.length - 1;
            int upperPos = longNums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (longNums[mid] == upperNum) {
                    upperPos = mid;
                    l = mid + 1;
                } else if (longNums[mid] > upperNum) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                    upperPos = mid;
                }
            }
            int changedNumCnt = Math.min(upperPos - i + 1, numOperations);
            answer = Math.max(answer, changedNumCnt);
        }
        return answer;
    }
}