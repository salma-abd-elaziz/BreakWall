package leetcode.mathANDnumbers;

public class TrailingZerosInFactorialN {

	/*
	 * Given an integer n, return the number of trailing zeroes in n!.
	 * O(log(N) base: 5) time, O(1) space.
	 */
	public int trailingZeroes(int n) {
		long factor = 5; // Because from 5^14, it can't be represented by int.
		int zerosNum = 0;
		while ((n / factor) > 0) {
			zerosNum += n / factor;
			factor *= 5;
		}
		return zerosNum;
	}

}
