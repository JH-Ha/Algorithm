package p100468;

import java.util.*;

class Solution {
    public int productionOfDigits(int num) {
        int production = 1;
        while (num > 0) {
            production *= num % 10;
            num /= 10;
        }
        return production;
    }

    public int smallestNumber(int n, int t) {
        int answer = n;
        for (int i = n; i <= 200; i++) {
            if (productionOfDigits(i) % t == 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}