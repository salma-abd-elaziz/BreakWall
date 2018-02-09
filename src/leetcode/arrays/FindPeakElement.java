package leetcode.arrays;

public class FindPeakElement {
	/*
	 * A peak element is an element that is greater than its neighbors.
	 * 
	 * Given an input array where num[i] ≠ num[i+1], find a peak element and
	 * return its index.
	 * 
	 * The array may contain multiple peaks, in that case return the index to
	 * any one of the peaks is fine
	 * 
	 * The goal of the problem is any peak in the array not necessary the
	 * maximum element of the array.
	 */

	// O(N)
	public int findPeakElement(int[] nums) {
		if (nums == null)
			return -1; // Error.
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1])
				return i;
		}
		return nums.length - 1;
	}

	// O(logN) binary search
	/*
	 * We start off by finding the middle element, mid from the given nums
	 * array. If this element happens to be lying in a descending sequence of
	 * numbers. or a local falling slope(found by comparing nums[i] to its right
	 * neighbor), it means that the peak will always lie towards the left of
	 * this element. Thus, we reduce the search space to the left of mid
	 * (including itself) and perform the same process on left subarray.
	 * 
	 * If the middle element, mid lies in an ascending sequence of numbers, or a
	 * rising slope(found by comparing nums[i] to its right neighbor), it
	 * obviously implies that the peak lies towards the right of this element.
	 * Thus, we reduce the search space to the right of mid and perform the same
	 * process on the right subarray.
	 */
	public int findPeakElementI(int[] nums) {
		if (nums == null)
			return -1; // Error.
		return binarySearch(nums, 0, nums.length - 1);
	}

	public int binarySearch(int[] nums, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] < nums[mid + 1]) {
				return binarySearch(nums, mid + 1, end);
			} else {
				return binarySearch(nums, start, mid);
			}
		}
		return start;
	}
}
