package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
	/*
	 * Given a positive integer n, find the least number of perfect square
	 * numbers
	 */

	// O(n^1.5) time, O(n) space
	public int numSquares(int n) {
		if (n <= 0)
			return 0;
		List<Integer> dp = new ArrayList<Integer>();
		dp.add(0);
		for (int i = 1; i <= n; i++) {
			int smallest = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				smallest = Math.min(smallest, dp.get(i - j * j) + 1);
			}
			dp.add(smallest);
		}
		return dp.get(dp.size() - 1);
	}

	// O(logn) because sqrt can be done in logarithmic time, using Legendre's
	// therom
	public int numSquaresI(int n) {
		if (n <= 0)
			return 0;

		// number is a perfect square
		if (isPerfectSquare(n))
			return 1;

		// Using Lengendre's theorem 4^k * (8 * m + 7).

		while (n % 4 == 0) {
			// remove the 4^k part.
			n >>= 2;
		}

		if (n % 8 == 7)
			return 4;

		int sqrt = (int) Math.sqrt(n);
		for (int i = 1; i <= sqrt; i++) {
			// Check if the remaining number is sum of two perfect squares.
			if (isPerfectSquare(n - i * i))
				return 2;
		}
		return 3;
	}

	private boolean isPerfectSquare(int number) {
		int root = (int) Math.sqrt(number);
		return root * root == number;
	}

}
