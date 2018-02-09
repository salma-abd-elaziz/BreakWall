package leetcode.arrays;

public class RemoveDuplicatesfromSortedArray {

	/*
	 * given a sorted array, remove the duplicates in-place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this by
	 * modifying the input array in-place with O(1) extra memory.
	 */

	// O(N) time ,O(1) space

	// When to shift-> when element is new, but in move zeros was when element
	// not equal 0

	public int removeDuplicates(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int p = 1;
		for (int i = 1; i < nums.length; i++) {
			// When to shift-> when the two elements not equal each other.
			if (nums[i - 1] != nums[i])
				nums[p++] = nums[i];
		}
		return p;
	}
}
