package lesson12.p1;

class Solution {
	public static long gcd(long a, long b) {
		while (b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public int solution(int N, int M) {
		// write your code in Java SE 8
		long left = N % M;
		if (left == 0) {
			return N / M;
		}
		long gcd = this.gcd(M, left);
		return (int) ((int) N / gcd);

	}
}

public class ChocolatesByNumbers {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int N = 10;
		int M = 4;
		System.out.println(solution.solution(N, M));
		System.out.println(solution.solution(10, 1));
		System.out.println(solution.solution(10, 2));
		System.out.println(solution.solution(10, 3));
		System.out.println(solution.solution(10, 5));
		System.out.println(solution.solution(10, 9));
	}
}
