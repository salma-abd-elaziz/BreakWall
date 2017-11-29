package leetcode;

public class SearchinRotatedSortedArray {

	// To find the smallest element in a sorted rotated array. O(nlogn)
	private int getShift(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start < end) { // when start = end, or the diff between them 1,
								// we reach the first elem
			int mid = (start + end) / 2;
			// smaller in second half.
			if (nums[mid] > nums[end])
				start = mid + 1;
			// smaller in first half.
			else
				end = mid; // the current could be the smallest elem
		}
		return start;
	}

	public int search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;

			// Correct flow? 1, 2, 3 .., then find the correct place.
			if (nums[start] <= nums[mid]) {
				if (nums[start] <= target && target < nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				if (nums[mid] < target && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}
}
