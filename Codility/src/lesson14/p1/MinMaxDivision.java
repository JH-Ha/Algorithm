package lesson14.p1;

class Solution {
	public int solution(int K, int M, int[] A) {
		// write your code in Java SE 8
		int l = 0;
		int r = M * A.length;
		int ans = M * A.length;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			int sum = 0;
			int numGroup = 1;
			int maxSum = 0;
			for (int i = 0; i < A.length; i++) {
				if (sum + A[i] > mid) {
					maxSum = Math.max(sum, maxSum);
					sum = A[i];
					numGroup++;
				} else {
					sum += A[i];
				}
			}
			maxSum = Math.max(sum, maxSum);
			if (numGroup > K) {
				l = mid + 1;
			} else {
				ans = Math.min(maxSum, ans);
				r = mid - 1;
			}
		}
		return ans;
	}
}

public class MinMaxDivision {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int K = 3;
		int M = 5;
		int[] A = { 2, 1, 5, 1, 2, 2, 2 };
		System.out.println(solution.solution(K, M, A));
	}
}
