package leetcode.mathANDnumbers;

public class ReverseInteger {

	/*
	 * Given a 32-bit signed integer, reverse digits of an integer.
	 * 
	 * Assume we are dealing with an environment which could only hold integers
	 * within the 32-bit signed integer range. For the purpose of this problem,
	 * assume that your function returns 0 when the reversed integer overflows.
	 */

	/*
	 * When to overflow, when a signed number like (2014483648) its reverse is
	 * (8463844102) which is out of signed int range .
	 * 
	 * if it overflows, it goes back to the minimum value and continues from
	 * there. If it underflows, it goes back to the maximum value and continues
	 * from there.
	 */

	public int reverseInteger(int x) {

		int base = 10;
		int result = 0;
		boolean negative = false;

		if (x < 0) {
			negative = true;
			x *= -1;
		}

		while (x > 0) {
			int temp = result;
			result *= base;
			result += x % base;
			// Overflows. if we reversed the operation the result will change.
			if (temp != (result - x % base) / base) return 0;
			x /= base;
		}

		if (negative) result *= -1;
		return result;
	}
}
