package leetcode;

public class MissingNumber {

	/*
	 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
	 * find the one that is missing from the array.
	 */

	// O(N) time, O(1) space.
	public int missingNumber(int[] nums) {
		int sum = 0;

		for (int i = 1; i <= nums.length; i++) {
			sum += i;
		}

		// sum = [N(N + 1)] / 2; Gauss' formula instead of the for loop
		int arrSum = 0;
		for (int num : nums) {
			arrSum += num;
		}

		return sum - arrSum;
	}

	// Bit manipulation.
	/*
	 * [0, 1, 3, 4]
	 * 
	 * missing = length = 4
	 * missing = missing^(0^0)^(1^1)^(2^3)^(3∧4) 
	 * = (4^4)^(0^0)^(1^1)^(3^3)^2 
	 * = 0^0^0^0^2
	 * = 2
	 * 
	 */
	public int missingNumberI(int[] nums) {
		int missing = nums.length;
		for (int i = 0; i < nums.length; i++) {
			missing ^= i ^ nums[i];
		}
		return missing;
	}

}
