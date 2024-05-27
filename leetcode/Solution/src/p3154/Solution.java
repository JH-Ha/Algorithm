package p3154;

import java.util.*;

class Solution {
    int combination(int n, int x) {
        if (x > n || x < 0) {
            return 0;
        }
        long ret = 1;
        for (int i = 1; i <= x; i++) {
            ret = ret * (n - i + 1) / i;
        }
        return (int) ret;
    }

    public int waysToReachStair(int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            ans += combination(i + 1, (1 << i) - k);
            System.out.println("i:" + i + " ans: " + ans);
        }
        return ans;
    }
}