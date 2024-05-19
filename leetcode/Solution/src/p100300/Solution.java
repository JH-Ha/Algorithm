package p100300;

class Solution {
    public long sumDigitDifferences(int[] nums) {
        int numDigits = 0;
        int tmpNum = nums[0];
        while (tmpNum > 0) {
            numDigits += 1;
            tmpNum /= 10;
        }
        int[][] cnt = new int[numDigits][10];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int pos = 0;
            while (num > 0) {
                cnt[pos][num % 10]++;
                num /= 10;
                pos++;
            }
        }

        // For debugging
        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[i].length; j++) {
                System.out.print(cnt[i][j] + " ");
            }
            System.out.println();
        }

        long ans = 0;
        for (int i = 0; i < numDigits; i++) {
            for (int j = 0; j < 10; j++) {
                long otherDigitCntSum = 0;
                for (int k = j + 1; k < 10; k++) {
                    otherDigitCntSum += cnt[i][k];
                }
                ans += otherDigitCntSum * cnt[i][j];
            }
        }
        return ans;
    }
}