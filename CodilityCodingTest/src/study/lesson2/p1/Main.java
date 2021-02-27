package study.lesson2.p1;

class Solution {
	public int[] solution(int[] A, int K) {
		// write your code in Java SE 8
		int[] ans = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int idx = (i - K) % A.length;
			if (idx < 0) {
				idx += A.length;
			}
			ans[i] = A[idx];
		}
		return ans;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = { 3, 8, 9, 7, 6 };
		int K = 3;
		int[] ans = solution.solution(A, K);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
