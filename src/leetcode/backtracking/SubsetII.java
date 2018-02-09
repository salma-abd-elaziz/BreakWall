package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

	/*
	 * Given a collection of integers that might contain duplicates, nums,
	 * return all possible subsets (the power set).
	 */

	/*
	 * example : [1 , 2, 1] 
	 * [ 
	 *		[2], 
	 *		[1], 
	 *		[1,2,2], 
	 *		[2,2], 
	 *		[1,2], 
	 *		[]
	 * ]
	 */
	public List<List<Integer>> subsetsDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtracking(result, new ArrayList<Integer>(), nums, 0);
		return result;
	}

	public void backtracking(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
		result.add(new ArrayList<Integer>(list));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue;
			list.add(nums[i]);
			backtracking(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
