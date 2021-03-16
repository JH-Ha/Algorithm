package lesson7.p1;

import java.util.Stack;

class Solution {
	public int solution(String S) {
		// write your code in Java SE 8
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '{' || c == '[' || c == '(') {
				stack.push(S.substring(i, i + 1));
			} else if (c == '}') {
				String top = stack.pop();
				if (!top.equals("{")) {
					return 0;
				}
			} else if (c == ']') {
				String top = stack.pop();
				if (!top.equals("["))
					return 0;
			} else if (c == ')') {
				String top = stack.pop();
				if (!top.equals("("))
					return 0;
			}
		}
		return 1;
	}
}

public class Brackets {
	public static void main(String[] args) {
		String S = "{[()()]}";
		Solution solution = new Solution();

		System.out.println(solution.solution(S));
	}
}
