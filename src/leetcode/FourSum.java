package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	/*Given an array S of n integers, are there elements a, b, c, 
	 * and d in S such that a + b + c + d = target? Find all unique
	 *  quadruplets in the array which gives the sum of target.*/
	
	// O(n^3) solution based on the 3Sum
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 4) return result;

		Arrays.sort(nums);

		for (int w = 0; w < nums.length - 3; w++) { // < size - 3
			if (w == 0 || nums[w] != nums[w - 1]) {
				for (int i = w + 1; i < nums.length - 2; i++) { // < size - 2
					// Enter in first iteration or no duplication.
					if (i == w + 1 || nums[i] != nums[i - 1]) { 
						int j = i + 1;
						int k = nums.length - 1;

						while (j < k) {

							if (nums[w] + nums[i] + nums[j] + nums[k] == target) {
								List<Integer> list = new ArrayList<Integer>();
								list.add(nums[w]);
								list.add(nums[i]);
								list.add(nums[j]);
								list.add(nums[k]);

								j++;
								k--;

								while (j < k && nums[j] == nums[j - 1])
									j++;
								while (j < k && nums[k] == nums[k + 1])
									k--;

								result.add(list);
							} else if (nums[w] + nums[i] + nums[j] + nums[k] < target) {
								j++;
							} else { // >.
								k--;
							}

						}
					}
				}
			}
		}
		return result;
	}
}
