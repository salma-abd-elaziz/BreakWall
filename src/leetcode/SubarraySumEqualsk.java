package leetcode;

public class SubarraySumEqualsk {

	/*Given an array of integers and an integer k,
	 *  you need to find the total number of continuous 
	 *  subarrays whose sum equals to k.*/
	
	public int subarraySum(int[] nums, int k) {
        int length = nums.length , subarraycount = 0;
        // Dp array will be reused for each element in the array.
        
        int[] dp;
        // For each element in the array.
        for (int i = 0; i < length; i++) {
        	
            dp = new int [length];
            // Add it to the next element, then to the next 2 elements,
            // then to the next three elements .....
            for (int j = i; j < length; j++) {
            	// Add each element in dp to the previous one
            	// which is the sum of the numbers before it.
                dp[j] = i == j? nums[i] : nums[j] + dp[j - 1];
                if (dp[j] == k) subarraycount++;
            } 
        }
        return subarraycount;
    }
}
