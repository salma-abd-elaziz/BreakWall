package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	/*
	 * Given an unsorted array of integers, find the length of longest
	 * increasing subsequence. not continuous sequence and not in sequence could
	 * be 1,5,6,8,101
	 */

	// DP Solution. O(N^2) time, O(N) space, where N is the number of elem's.
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length < 1)
			return 0;
		int[] max = new int[nums.length];
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			max[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) { // increasing order.
					max[i] = Math.max(max[i], max[j] + 1);
				}
			}
			res = Math.max(res, max[i]);
		}
		return res;
	}

	// O(NlogN) time, O(N) space. binary search idea
	// the list will be sorted so we can do that.
	public int lengthOfLISI(int[] nums) {
		if (nums == null || nums.length < 1)
			return 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int num : nums) {
			if (list.size() == 0 || num > list.get(list.size() - 1)) {
				list.add(num);
			} else {
				int index = getPlace(num, list);
				list.set(index, num);
			}
		}
		return list.size();
	}

	private int getPlace(int num, List<Integer> list) {
		int start = 0;
		int end = list.size() - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			// we are searching for num bigger than me, then the first condition is
			// opposite what i need
			if (list.get(mid) < num)
				start = mid + 1;
			else
				end = mid; // not mid - 1 as mid might be what I'm looking for
		}
		return start;
	}
}
