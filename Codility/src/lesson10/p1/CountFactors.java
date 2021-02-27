package lesson10.p1;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int solution(int N) {
		// write your code in Java SE 8
		long MAX_NUM = 500000;
		boolean[] isPrime = new boolean[(int) MAX_NUM];
		for (int i = 0; i < MAX_NUM; i++) {
			isPrime[i] = true;
		}
		for (long i = 2; i < MAX_NUM; i++) {
			if (isPrime[(int) i]) {
				for (long j = i * i; j < MAX_NUM; j += i) {
					isPrime[(int) j] = false;
				}
			}
		}
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < MAX_NUM; i++) {
			if (isPrime[i])
				primes.add(i);
		}
		int ans = 1;
		for (Integer prime : primes) {
			int checkN = N;
			int numPrime = 0;
			while (checkN % prime == 0) {
				numPrime++;
				checkN /= prime;
			}
			if (numPrime > 0) {
				ans *= (numPrime + 1);
			}
		}
		if (ans == 1) {
			ans = 2;
		}
		if (N == 1) {
			ans = 1;
		}
		return ans;
	}
}

public class CountFactors {
	public static void main(String[] args) {
		Solution solution = new Solution();
		// System.out.println(solution.solution(24));
		// System.out.println(solution.solution(3628800));
		System.out.println(solution.solution(5621892));
		// N=3,628,800=10!, N=5,621,892,
	}
}
