package leetcode.strings;

import java.util.*;

class PartitionLabels {

	/*
	 * A string S of lowercase letters is given. We want to partition this
	 * string into as many parts as possible so that each letter appears in at
	 * most one part, and return a list of integers representing the size of
	 * these parts.
	 * 
	 * Input: S = "ababcbacadefegdehijhklij" Output: [9,7,8] Explanation: The
	 * partition is "ababcbaca", "defegde", "hijhklij".
	 */

	// O(N) time where N is the length of S, O(1) space
	public List<Integer> partitionLabels(String S) {
		List<Integer> list = new ArrayList<Integer>();
		if (S == null || S.length() < 1)
			return list;

		int[] arr = new int[26]; // Space.
		for (int i = 0; i < S.length(); i++) {
			arr[S.charAt(i) - 'a'] = i;
		}

		int j = 0;
		int anchor = 0;

		for (int i = 0; i < S.length(); i++) {
			j = Math.max(j, arr[S.charAt(i) - 'a']);
			// The end of the partition reached.
			if (i == j) {
				list.add(j - anchor + 1);
				anchor = j + 1;
			}
		}
		return list;
	}
}
