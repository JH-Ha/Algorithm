package Java.src.stealing;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        dp1[0] = money[0];
        dp1[1] = money[1];
        dp2[0] = 0;
        dp2[1] = money[1];
        dp2[2] = money[2];
        for (int i = 2; i < n - 1; i++) {
            if (i - 2 >= 0) {
                dp1[i] = Math.max(dp1[i], dp1[i - 2] + money[i]);
            }
            if (i - 3 >= 0) {
                dp1[i] = Math.max(dp1[i], dp1[i - 3] + money[i]);
            }
        }
        for (int i = 3; i < n; i++) {
            if (i - 2 >= 0) {
                dp2[i] = Math.max(dp2[i], dp2[i - 2] + money[i]);
            }
            if (i - 3 >= 0) {
                dp2[i] = Math.max(dp2[i], dp2[i - 3] + money[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            answer = Math.max(dp1[i], answer);
            answer = Math.max(dp2[i], answer);
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] money = { 1, 2, 3, 1 };
        Solution solution = new Solution();
        System.out.println(solution.solution(money));
    }
}
