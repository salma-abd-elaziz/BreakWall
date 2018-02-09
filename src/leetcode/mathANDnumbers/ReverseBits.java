package leetcode.mathANDnumbers;

public class ReverseBits {

	/*
	 * Reverse bits of a given 32 bits unsigned integer.
	 * 
	 * For example, given input 43261596 (represented in binary as 0000 0010
	 * 1001 0100 0001 1110 1001 1100), return 964176192 (represented in binary
	 * as 00111001011110000010100101000000).
	 */

	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < (Integer.BYTES * 8) - 1; i++) {
			result |= n & 1;
			result <<= 1;
			n >>>= 1;
		}
		// Because the 31 time we would shift result while we don't need to so
		// we made the loop loops 30 times and we do the 31 time, or we can just
		// shift before oring ;)
		result |= n & 1;
		return result;
	}

}
