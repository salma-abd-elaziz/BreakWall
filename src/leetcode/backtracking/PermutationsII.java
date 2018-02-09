package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PermutationsII {

	/*
	 * Given a collection of numbers that might contain duplicates, return all
	 * possible unique permutations.
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// to be able to remove duplicates subsets. as [1,1,2] and [1,1,2] which
		// is coming from different elements in the array
		Arrays.sort(nums);
		backtracking(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
		return result;
	}

	public void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] isUsed) {
		if (list.size() == nums.length) {
			res.add(new ArrayList(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			// we would not be able to use the second condition if the array not
			// sorted.
			if (isUsed[i] || (i > 0 && nums[i] == nums[i - 1] && isUsed[i - 1]))
				continue;
			list.add(nums[i]);
			isUsed[i] = true;
			backtracking(res, list, nums, isUsed);
			list.remove(list.size() - 1);
			isUsed[i] = false;
		}

	}
}
