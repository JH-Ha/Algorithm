package lesson3.p3;

class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8
		int sum = 0;
		int[] pSum = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			pSum[i] = sum;
		}
		int ans = 2000000000;
		for (int i = 0; i < A.length - 1; i++) {
			ans = Math.min(ans, Math.abs(2 * pSum[i] - sum));
		}

		return ans;
	}
}

public class TapeEquilibrium {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = { 3, 1, 2, 4, 3 };
		System.out.println(solution.solution(A));
	}
}
