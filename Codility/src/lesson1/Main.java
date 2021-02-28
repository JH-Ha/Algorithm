package lesson1;

class Solution {
	public int solution(int N) {
		// write your code in Java SE 8
		StringBuilder builder = new StringBuilder();
		while (N > 0) {
			if (N % 2 == 0) {
				builder.append(0);
			} else {
				builder.append(1);
			}
			N /= 2;
		}

		String binaray = builder.toString();
		int maxLength = 0;
		boolean isStart = false;
		int curLen = 0;
		for (int i = 0; i < binaray.length(); i++) {
			if (!isStart && binaray.charAt(i) == '1') {
				isStart = true;
				curLen = 0;
			}
			if (isStart && binaray.charAt(i) == '0') {
				curLen++;
			}
			if (isStart && binaray.charAt(i) == '1') {
				maxLength = Math.max(maxLength, curLen);
				curLen = 0;
			}
		}
		System.out.println(binaray);
		return maxLength;

	}
}

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(20));
		System.out.println(solution.solution(9));
		System.out.println(solution.solution(529));
	}
}
