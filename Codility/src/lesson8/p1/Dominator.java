package lesson8.p1;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			map.put(A[i], map.getOrDefault(A[i], 0) + 1);
		}

		int maxKey = -1;
		for (Integer key : map.keySet()) {
			Integer value = map.get(key);
			if (value > A.length / 2) {
				maxKey = key;
				break;
			}
		}
		if (maxKey != -1) {
			for (int i = 0; i < A.length; i++) {
				if (A[i] == maxKey) {
					return i;
				}
			}
		}
		return maxKey;
	}
}

public class Dominator {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = { 3, 4, 3, 2, 3, -1, 3, 3 };
		System.out.println(solution.solution(A));
	}
}
