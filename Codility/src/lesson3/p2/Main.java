package lesson3.p2;

import java.util.Arrays;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8
		Arrays.sort(A);
		int ans = A.length + 1;

		for (int i = 0; i < A.length; i++) {
			if (i + 1 != A[i]) {
				ans = i + 1;
				break;
			}
		}
		return ans;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = { 2, 3, 1, 5 };
		int[] A2 = { 2, 3, 1, 4 };
		System.out.println(solution.solution(A));
		System.out.println(solution.solution(A2));
	}
}
