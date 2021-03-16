package lesson4.p1;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(int X, int[] A) {
		// write your code in Java SE 8
		Set<Integer> set = new HashSet<Integer>();
		int ans = -1;
		for (int i = 0; i < A.length; i++) {
			set.add(A[i]);
			if (set.size() == X) {
				ans = i;
				break;
			}
		}
		return ans;
	}
}

public class FrogRiverOne {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int X = 5;
		int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 };
		System.out.println(solution.solution(X, A));
	}
}
