package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	/*
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence(in count not in plaec). EX: Given [100, 4,
	 * 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4].
	 * Return its length: 4.
	 */
	// using sorting or HashSet.
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length < 1)
			return 0;
		// One element.
		if (nums.length < 2)
			return 1;
		// Using HashSet to be able to access elements in O(1).
		Set<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			set.add(num);
		}
		int maxLength = 0;
		for (int num : set) {
			// Find the start of the sequence.
			if (!set.contains(num - 1)) {
				int searchFor = num + 1;
				int len = 1;
				// Search for the sequence.
				while (set.contains(searchFor)) {
					searchFor++;
					len++;
				}
				// Update maxLength.
				maxLength = Math.max(maxLength, len);
			}
		}
		return maxLength;
	}

}
