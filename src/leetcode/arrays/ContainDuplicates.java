package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicates {
	/*
	 * Given an array of integers, find if the array contains any duplicates.
	 * Your function should return true if any value appears at least twice in
	 * the array, and it should return false if every element is distinct.
	 */

	// O(N) time, O(1) space.
	// Will not work in case of numbers bigger than 32,
	// because mask is only 32 bits.

	public boolean containsDuplicateI(int[] nums) {
		if (nums.length <= 0)
			return false;
		int mask = 0;
		for (int num : nums) {
			// If element already exits.
			if ((mask & (1 << num)) != 0)
				return true;
			mask |= 1 << num;
		}
		return false;
	}

	// O(N) time, O(n) space.
	// work in case of big numbers.
	public boolean containsDuplicateII(int[] nums) {
		if (nums.length <= 0)
			return false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			// If element already exits.
			if (map.containsKey(num))
				return true;
			map.put(num, 1);
		}
		return false;
	}
	

}
