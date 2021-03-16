package lesson14.p2;

import java.util.Arrays;

class Solution {
	public int solution(int[] A, int[] B, int[] C) {
		// write your code in Java SE 8
		int l = 0;
		int r = C.length;
		int ans = C.length + 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			boolean[] isNailed = new boolean[A.length];
			Arrays.fill(isNailed, false);

			int numNailed = 0;
			for (int i = 0; i < mid; i++) {
				for (int j = 0; j < A.length; j++) {
					if (!isNailed[j]) {
						if (A[j] <= C[i] && C[i] <= B[j]) {
							isNailed[j] = true;
							numNailed++;
						}
					}
				}
			}
			if (numNailed == A.length) {
				ans = Math.min(ans, mid);
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}
		if (ans == C.length + 1) {
			ans = -1;
		}
		return ans;
	}
}

public class NailingPlanks {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = { 1, 4, 5, 8 };
		int[] B = { 4, 5, 9, 10 };
		int[] C = { 4, 6, 7, 10, 2 };
		System.out.println(solution.solution(A, B, C));
	}
}
