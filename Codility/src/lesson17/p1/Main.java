package lesson17.p1;

import java.util.Arrays;

class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8
		int N = A.length;
		int M = 0;
		int S = 0;
		for (int i = 0; i < N; i++) {
			A[i] = Math.abs(A[i]);
			M = Math.max(A[i], M);
			S += A[i];
		}
		int[] count = new int[M + 1];
		Arrays.fill(count, 0);
		for (int i = 0; i < N; i++) {
			count[A[i]]++;
		}
		int[] dp = new int[S + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		for (int a = 1; a <= M; a++) {
			if (count[a] > 0) {
				for (int j = 0; j < S; j++) {
					if (dp[j] >= 0) {
						dp[j] = count[a];
					} else if (j >= a && dp[j - a] > 0) {
						dp[j] = dp[j - a] - 1;
					}
				}
			}
		}
		int result = S;
		for (int i = 0; i < S / 2 + 1; i++) {
			if (dp[i] >= 0) {
				result = Math.min(result, S - 2 * i);
			}
		}
		return result;
	}

}

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = { 1, 5, 2, -2 };
		System.out.println(solution.solution(A));
	}
}
