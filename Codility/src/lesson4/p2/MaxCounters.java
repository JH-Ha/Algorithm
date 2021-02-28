package lesson4.p2;

import java.util.Arrays;

class Solution {
	public int[] solution(int N, int[] A) {
		// write your code in Java SE 8
		int numMax = 0;
		int toMax = -1;
		int[] ans = new int[N];
		Arrays.fill(ans, 0);

		for (int i = 0; i < A.length; i++) {
			if (A[i] == N + 1) {
				toMax = numMax;
			} else {

				if (toMax != -1 && ans[A[i] - 1] < toMax) {
					ans[A[i] - 1] = toMax;
				}
				ans[A[i] - 1]++;
				if (ans[A[i] - 1] > numMax) {
					numMax = ans[A[i] - 1];
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (ans[i] < toMax) {
				ans[i] = toMax;
			}
		}
		return ans;
	}
}

public class MaxCounters {
	public static void main(String[] args) {
		int N = 5;
		int[] A = { 3, 4, 4, 6, 1, 4, 4 };
		Solution solution = new Solution();
		int[] ans = solution.solution(N, A);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}
}
