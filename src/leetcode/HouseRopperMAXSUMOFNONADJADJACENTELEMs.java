package leetcode;

public class HouseRopperMAXSUMOFNONADJADJACENTELEMs {
	/*
	 * The idea is to get the maximum sum of the array, but the elements that is
	 * in the summation are not adjacent. we need to keep to sum and take the
	 * larger one
	 */
	public int rob(int[] nums) {
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				/*
				 * Skip or take this element, depends on the gain that I get
				 * from skipping, if the second sum is greater then we skip and
				 * use the second sum to continue
				 */
				sum1 = Math.max(sum2, sum1 + nums[i]);
			} else {
				sum2 = Math.max(sum1, sum2 + nums[i]);
			}

		}
		return Math.max(sum1, sum2);
	}
    /* Ex : [9, 9, 9, 8, 1, 2]  the max sum is the sum of indices 0, 2, 5 */
}

