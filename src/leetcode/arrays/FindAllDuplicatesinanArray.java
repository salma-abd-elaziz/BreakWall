package leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesinanArray {

	/*
	 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some
	 * elements appear twice and others appear once.
	 * 
	 * Find all the elements that appear twice in this array.
	 */
	
	// O(N) time and O(N) space, where N is the array size.
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length < 1)
			return res;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i])) {
				res.add(nums[i]);
			}
		}
		return res;
	}

	// O(N) time and O(1) space, where N is the length of the array.
	public List<Integer> findDuplicatesI(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length < 1)
			return res;
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			// Duplicate?
			if (nums[num - 1] < 0)
				res.add(num);
			else
				nums[num - 1] = -nums[num - 1];
		}
		return res;
	}
}
