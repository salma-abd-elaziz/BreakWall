package leetcode.arrays;

public class SingleElementinaSortedArray {
	/*
	 * Given a sorted array consisting of only integers where every element
	 * appears twice except for one element which appears once. Find this single
	 * element that appears only once.
	 */

	// O(N) time, O(1) space.
	public int singleNonDuplicate(int[] nums) {
		int res = 0;
		for (int x : nums) {
			res ^= x;
		}
		return res;
	}

	// O(logN) time, O(1) space
	public int singleNonDuplicateI(int[] nums) {
		int start = 0, end = nums.length - 1;

		while (start < end) {
			int mid = (start + end) / 2;
			// find the start of the pair.
			if (mid % 2 == 1)
				mid--;

			// left half not correct - go right.
			if (nums[mid] != nums[mid + 1])
				end = mid;
			// correct - take two steps.
			else
				start = mid + 2;
		}

		return nums[start];
	}
}
