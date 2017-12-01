package leetcode;

public class IncreasingTripletSubsequence {
	/*
	 * Given an unsorted array return whether an increasing subsequence of
	 * length 3 exists or not in the array, not continuous sequence and not
	 * continuous numbers ex : [2,4,-2,5] returns true as 2,4,5
	 */

	public boolean increasingTriplet(int[] nums) {
		int small = Integer.MAX_VALUE;
		int big = Integer.MAX_VALUE;

		for (int num : nums) {
			if (num <= small) small = num;
			else if (num <= big) big = num;
			// bigger than big. FOUND.
			else return true;
		}
		return false;
	}
}
