package lesson15.p2;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(int M, int[] A) {
		// write your code in Java SE 8
		Set<Integer> set = new HashSet<Integer>();
		long ans = 0;
		int left = 0;
		int right = 0;
		while (left <= right && right < A.length) {
			if (!set.contains(A[right])) {
				set.add(A[right]);
				right++;
				ans += set.size();
			} else {
				set.remove(A[left]);
				left++;
			}
		}

		return (int) Math.min(ans, 1000000000);

	}
}

public class CountDistinctSlices {
	public static void main(String[] args) {
		int M = 6;
		int[] A = { 3, 4, 5, 5, 2 };
		int[] A2 = { 3, 3, 3, 3, 3, 2, 3, 1, 1, 1 };
		int[] A3 = { 2, 1, 0, 1, 3 };
		int[] A4 = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		System.out.println(new Solution().solution(M, A));
		System.out.println(new Solution().solution(M, A2));
		System.out.println(new Solution().solution(M, A3));
		System.out.println(new Solution().solution(M, A4));
	}
}
