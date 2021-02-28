package lesson3.p1;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	public int solution(int X, int Y, int D) {
		// write your code in Java SE 8
		double diff = Y - X;
		int ans = (int) Math.ceil(diff / D);
		return ans;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int X = 10;
		int Y = 85;
		int D = 30;
		System.out.println(solution.solution(X, Y, D));
	}
}
