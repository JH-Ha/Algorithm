package lesson2.p2;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			Integer cnt = map.get(A[i]);
			if (cnt == null) {
				map.put(A[i], 1);
			} else {
				map.put(A[i], cnt + 1);
			}
		}
		int ans = 0;
		for (Integer key : map.keySet()) {
			int cnt = map.get(key);
			if (cnt % 2 == 1) {
				ans = key;
			}
		}
		return ans;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = { 9, 3, 9, 3, 9, 7, 9 };
		int ans = solution.solution(A);
		System.out.println(ans);
	}
}
