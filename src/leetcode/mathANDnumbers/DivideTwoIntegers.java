package leetcode.mathANDnumbers;

public class DivideTwoIntegers {
	/*
	 * Divide two integers without using multiplication, division and mod
	 * operator.
	 */
	public int divide(int dividend, int divisor) {
		if (dividend == 0) return 0;
		boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
		long y = (long) Math.abs((long) dividend);
		long x = (long) Math.abs((long) divisor);
		if (y < x) return 0;
		long res = divideHelper(y, x);
		// Overflow.
		if (res > Integer.MAX_VALUE) return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		if (negative) return (int) -res;
		return (int) res;
	}

	public long divideHelper(long dividend, long divisor) {
		if (divisor == 1) return dividend;
		long multiple = 1;
		long fraction = divisor;

		while ((dividend - fraction) >= divisor) {
			fraction += divisor;
			multiple++;
		}
		return multiple;
	}
}
