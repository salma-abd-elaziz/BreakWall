package leetcode;

public class MaxSubarraySum {

	/*
	 * the sub problem : the new sum is bigger than me. O(n) time, O(n) space.
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
	
	
	//O(N) time ,O(1) space.
	public int maxSubArrayI(int[] nums) {
		if (nums == null || nums.length == 0)
			return Integer.MIN_VALUE;
		int maxSum = 0;
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// The new sum is bigger than me ? yes then continue the chain else
			// start from me.
			if (sum + nums[i] > nums[i]) {
				sum += nums[i];
			} else {
				maxSum = Math.max(maxSum, sum);
				sum = nums[i];
			}
		}
		
		return Math.max(maxSum, sum);
	}

	// Max length of increasing sequence O(N) time O(1) space.(continuous, not in sequence could be 1, 5, 7)
	public int lengthOfLIS(int[] nums) {
		if (nums.length < 1)
			return 0;
		int maxLen = 0;
		int len = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] >= nums[i - 1])
				len++;
			else {
				maxLen = Math.max(maxLen, len);
				len = 1;
			}
		}
		return Math.max(maxLen, len);
	}
}
