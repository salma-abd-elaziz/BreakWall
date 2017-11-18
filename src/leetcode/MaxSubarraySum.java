package leetcode;

public class MaxSubarraySum {

	/*
	 * the sub problem : the new sum is bigger than me.
	 * O(n) time, O(n) space.
	 */

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return Integer.MIN_VALUE;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// The new sum is bigger than me ? yes then continue the chain else
			// start from me.
			dp[i] = dp[i - 1] + nums[i] > nums[i] ? dp[i - 1] + nums[i] : nums[i];
		}
		// Find the maximum sum.
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			if (result < dp[i])
				result = dp[i];
		}
		return result;
	}
}
