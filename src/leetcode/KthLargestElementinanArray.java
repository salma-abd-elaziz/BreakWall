package leetcode;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {

	/*
	 * Find the kth largest element in an unsorted array. Note that it is the
	 * kth largest element in the sorted order, not the kth distinct element.
	 */

	// nlogk
	public int findKthLargest(int[] nums, int k) {
		if (k == 0 || nums.length < 1)
			return -1;
		
		PriorityQueue<Integer> kLargest = new PriorityQueue<>();
		for (int num : nums) {
			kLargest.add(num);
			if (kLargest.size() > k)
				kLargest.remove();
		}
		return kLargest.peek();
	}
}
