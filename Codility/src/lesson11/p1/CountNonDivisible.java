package lesson11.p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public int[] solution(int[] A) {
		// write your code in Java SE 8
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			map.put(A[i], map.getOrDefault(A[i], 0) + 1);
		}
		int[] ans = new int[A.length];

		Arrays.fill(ans, A.length);

		for (int i = 0; i < A.length; i++) {
			for (int j = 1; j * j <= A[i]; j++) {
				if (A[i] % j == 0) {
					// 제곱수가 아닌경우
					if (A[i] / j != j) {
						ans[i] -= map.getOrDefault((A[i] / j), 0);
					}
					ans[i] -= map.getOrDefault(j, 0);
				}
			}
		}
		return ans;

	}
}

public class CountNonDivisible {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = { 3, 1, 2, 3, 6 };
		int[] A2 = { 1, 2, 3, 4, 5 };
		int[] ans = solution.solution(A);
		int[] ans2 = solution.solution(A2);

		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		for (int i = 0; i < ans2.length; i++) {
			System.out.println(ans2[i]);
		}
	}
}
