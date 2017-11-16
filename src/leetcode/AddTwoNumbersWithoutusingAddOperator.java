package leetcode;

public class AddTwoNumbersWithoutusingAddOperator {

	/*
	 * Calculate the sum of two integers a and b, but you are not allowed to use
	 * the operator + and -. 
	 * using the XOR and AND operators, XOR is used for the summing 
	 * while AND is used to get the carry c << 1, to move the carry
	 * bits to the next place.
	 * 
	 *  
	 */

	public int getSum(int a, int b) {
		while (b != 0) {
			int c = a & b;
			a ^= b;
			b = c << 1;
		}
		return a;
	}
}
