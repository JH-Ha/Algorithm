package p100466;

import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        int answer = 1;

        // case no.1. don't change the target number
        int i = 0;
        int sameNumCnt = 1;
        while (i < nums.length) {
            if (i + 1 < nums.length) {
                if (nums[i] == nums[i + 1]) {
                    sameNumCnt++;
                    i++;
                    continue;
                }
            }

            int lowNum = nums[i] - k;
            int l = 0;
            int r = nums.length - 1;
            int lowPos = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == lowNum) {
                    lowPos = mid;
                    r = mid - 1;
                } else if (nums[mid] > lowNum) {
                    lowPos = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            int upperNum = nums[i] + k;
            l = 0;
            r = nums.length - 1;
            int upperPos = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == upperNum) {
                    upperPos = mid;
                    l = mid + 1;
                } else if (nums[mid] > upperNum) {
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
        for (i = 0; i < nums.length; i++) {
            int upperNum = nums[i] + 2 * k;
            int l = 0;
            int r = nums.length - 1;
            int upperPos = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == upperNum) {
                    upperPos = mid;
                    l = mid + 1;
                } else if (nums[mid] > upperNum) {
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