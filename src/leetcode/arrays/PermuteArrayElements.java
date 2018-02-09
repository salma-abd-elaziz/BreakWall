package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class PermuteArrayElements {

	/*
	 * Given a collection of distinct numbers, return all possible permutations.
	 */
	// O(n^2) ?
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permute(result, new ArrayList<Integer>(), nums);
		return result;
	}

	public void permute(List<List<Integer>> result, List<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i]))
				continue;
			list.add(nums[i]);
			permute(result, list, nums);
			list.remove(list.size() - 1);
		}
	}
}
