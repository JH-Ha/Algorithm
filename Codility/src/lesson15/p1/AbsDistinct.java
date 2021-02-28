package lesson15.p1;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			set.add(Math.abs(A[i]));
		}
		return set.size();
	}
}

public class AbsDistinct {
	public static void main(String[] args) {
		int[] A = { -5, -3, -1, 0, 3, 6 };
		System.out.println(new Solution().solution(A));
	}
}
