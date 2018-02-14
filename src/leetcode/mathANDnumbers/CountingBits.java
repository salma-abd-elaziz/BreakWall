package leetcode.mathANDnumbers;

public class CountingBits {
	/*
	 * Given a non negative integer number num. For every numbers i in the range
	 * 0 ≤ i ≤ num calculate the number of 1's in their binary representation
	 * and return them as an array.
	 * 
	 * Example: For num = 5 you should return [0,1,1,2,1,2].
	 */

	// O(num) time. 
	public int[] countBits(int num) {
		int[] res = new int[num + 1];

		for (int i = 0; i <= num; i++) {
			res[i] = res[i / 2] + (i % 2);

		}
		return res;
	}
	
	// Another solution O(num * max number of ones in a number) we can say O(num)
	public int[] countBitsI(int num) {
        int[] res = new int[num + 1];
        
        for (int i = 0; i <= num; i++) {
            for (int j = i; j > 0; j &= (j - 1)) {
                res[i]++; 
            }
        }
        return res;
    }
}


