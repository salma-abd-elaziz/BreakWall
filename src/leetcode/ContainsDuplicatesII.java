package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicatesII {

	/*
	 * Given an array of integers and an integer k, find out whether there are
	 * two distinct indices i and j in the array such that nums[i] = nums[j] and
	 * the absolute difference between i and j is at most k.
	 * 
	 */

	// O(N) time, O(N) space.

	
	public boolean containsNearbyDuplicateI(int[] nums, int k) {
		// the key is the num, the value is a list of the indices that this
		// num appeared in, In case that the number could appear more than
		// once, if not we can use Map<Integer, Integer>
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		if (k == 0 || nums.length <= 1)
			return false;
		for (int i = 0; i < nums.length; i++) {
			List<Integer> list = null;
			if (!map.containsKey(nums[i])) {
				list = new ArrayList<Integer>();
			} else {
				list = map.get(nums[i]);
				for (int index : list) {
					if (Math.abs(i - index) <= k)
						return true;
				}
			}
			list.add(i);
			map.put(nums[i], list);
		}
		return false;
	}
}
