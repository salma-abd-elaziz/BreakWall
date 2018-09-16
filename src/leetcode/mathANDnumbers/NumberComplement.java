package leetcode.mathANDnumbers;

public class NumberComplement {

	/*
	 * Given a positive integer, output its complement number. The complement
	 * strategy is to flip the bits of its binary representation.
	 * 
	 * Note: 1 - The given integer is guaranteed to fit within the range of a
	 * 32-bit signed integer. 2 - You could assume no leading zero bit in the
	 * integer’s binary representation.
	 * 
	 * Complement the number then remove the leading (flipped leading zeros)
	 * ones.
	 */
	public int c(int num) {
		return ~num & (Integer.highestOneBit(num) - 1);
	}
}
