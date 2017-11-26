package leetcode;

import java.util.Arrays;

public class FindtheDuplicateNumber {

	// O(N) time, O(1) space.
	public int findDuplicate(int[] nums) {

		Arrays.sort(nums);

		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == nums[i])
				return nums[i];
		}
		return -1;
	}

	// using the binary search.
	/*
	 * This idea is working when one element appears at twice, we return that
	 * element.
	 */
	public int findDuplicateO(int[] nums) {
		Arrays.sort(nums);
		return binarySearchApproach(nums, 0, nums.length - 1);
	}

	public int binarySearchApproach(int[] nums, int start, int end) {
		if (start > end)
			return -1;

		int mid = (start + end) / 2;

		// found go right
		if (nums[mid] == mid + 1) {
			int val = binarySearchApproach(nums, mid + 1, end);
			if (val == -1)
				return nums[mid];
			return val;
		}
		// Not found.
		int val = binarySearchApproach(nums, start, mid - 1);
		if (val == -1)
			return nums[mid];
		return val;
	}
}
