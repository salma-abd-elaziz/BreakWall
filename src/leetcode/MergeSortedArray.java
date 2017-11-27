package leetcode;

public class MergeSortedArray {

	/*
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1
	 * as one sorted array.
	 */

	// O(m+n) time, O(1) space.
	/* The idea is to fill the array from the back. */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int j = m - 1;
		int i = n - 1;
		int fillingIndex = m + n - 1;
		
		while (i >= 0 && j >= 0) {
			if (nums1[j] > nums2[i]) {
				nums1[fillingIndex--] = nums1[j--];
			} else if (nums1[j] < nums2[i]) {
				nums1[fillingIndex--] = nums2[i--];
			} else { // Equal.
				nums1[fillingIndex--] = nums1[j--];
				nums1[fillingIndex--] = nums2[i--];
			}
		}

		while (i >= 0) {
			nums1[fillingIndex--] = nums2[i--];
		}
		// we didn't handle if j is still bigger than 0, because the elements
		// will be in its correct place already in nums1 array.
	}
}
