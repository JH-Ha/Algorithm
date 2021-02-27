package lesson4.p4;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8
		int ans = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= A.length) {
				set.add(A[i]);
			} else {
				return 0;
			}
		}
		if (set.size() != A.length) {
			return 0;
		}

		return 1;
	}
}

public class PermCheck {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = { 4, 1, 3, 2 };
		int[] A2 = { 4, 1, 3 };
		System.out.println(solution.solution(A));
		System.out.println(solution.solution(A2));
	}
}
