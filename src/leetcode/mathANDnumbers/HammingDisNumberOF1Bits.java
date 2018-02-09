package leetcode.mathANDnumbers;

public class HammingDisNumberOF1Bits {

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int noOfOnes = 0;
		/*
		 * Need to convert n to long to be able to convert it to unsigned
		 * integer or this case will be fail (2147483648) will be out of int
		 * range
		 */
		long num = n & 0x00000000ffffffffL; // L for long
		while (num > 0) {
			noOfOnes += (num & 1);
			num >>>= 1;
		}
		return noOfOnes;
	}

	// To not transform to unsigned integer.
	public int hammingDistanceI(int n) {
		int hammingDistance = 0;
		int mask = 1;
		for (int i = 0; i < Integer.BYTES * 8; i++) {
			if ((mask & n) != 0)
				hammingDistance++;
			mask <<= 1;
		}
		return hammingDistance;
	}

	/*
	 * Optimized solution. if we have 010.... 100, all previous solutions would
	 * iterate 3 steps to reach the most right 1, while this reaches the most
	 * right 1 in one step.
	 */
	public int hammingWeightII(int n) {
		int sum = 0;
		for (int i = n; i != 0; i = i & (i - 1)) {
			sum++;
		}
		return sum;
	}
}
