import java.util.Arrays;

public class Simsa {
    class Solution {
        public long solution(int n, int[] times) {

            int biggest = times[0];
            for (int i = 1; i < times.length; i++) {
                biggest = Math.max(biggest, times[i]);
            }

            long l = 0;
            long r = (long) biggest * (long) n;
            long answer = 0;
            while (l <= r) {
                long mid = l / 2 + r / 2;
                long num = 0;
                for (int time : times) {
                    num += mid / time;
                }
                if (num >= n) {
                    answer = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Simsa simsa = new Simsa();
        Solution solution = simsa.new Solution();
        int n = 6;
        int[] times = { 7, 10 };
        System.out.println(solution.solution(n, times));
    }
}
