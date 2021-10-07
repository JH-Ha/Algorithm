package monthlyChallenge202110.p2;

class Solution {
    public long find(int n, long num) {
        long i = num / n;
        long j = num % n;
        if (i <= j) {
            return j + 1;
        }
        return i + 1;
    }

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        for (long i = left; i <= right; i++) {
            answer[(int) (i - left)] = (int) find(n, i);
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int left = 2;
        int right = 5;
        int[] answer = solution.solution(n, left, right);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
