package leetcode.mathANDnumbers;

public class HammingDistance {
	/*
	 * The Hamming distance between two integers is the number of positions at
	 * which the corresponding bits are different.
	 * 
	 * Given two integers x and y, calculate the Hamming distance.
	 */

	public int hammingDistance(int x, int y) {
		int count = 0;
		for (int i = y ^ x; i != 0; i = i & (i - 1))
			count++;
		return count;
	}

}
