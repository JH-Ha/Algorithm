package lesson4.p3;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				set.add(A[i]);
			}
		}
		int ans = 0;
		for (int i = 1; i <= 100001; i++) {
			if (!set.contains(i)) {
				ans = i;
				break;
			}
		}
		return ans;
	}
}

public class MissingInteger {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = { 1, 3, 6, 4, 1, 2 };
		System.out.println(solution.solution(A));
	}
}
