package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	/*
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than ⌊ n/2 ⌋ times.
	 */

	/*
	 * This can be solved also in O(NlogN) time by sorting the array and
	 * returning the middle element
	 */
	
	/* O(N) time, O(N) space, where N is the size of the array*/
	public int majorityElementI(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		// majority element is the key in map.
		int majorityElement = Integer.MIN_VALUE;
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (majorityElement == Integer.MIN_VALUE || e.getValue() > map.get(majorityElement))
				majorityElement = e.getKey();
		}
		return majorityElement;
	}

	/* O(N) time, O(1) space */
	public int majorityElementII(int[] nums) {
		int count = 0;
		int candidate = 0;
		for (int num : nums) {
			if (count == 0)
				candidate = num;
			// (assuming a majority element exists)
			// This work because the element exists more than half the array
			count += num == candidate ? 1 : -1;
		}
		return candidate;
	}

}
