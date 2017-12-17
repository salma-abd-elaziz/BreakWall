package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	/*
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * 
	 * Return all possible palindrome partitioning of s.
	 */

	// Backtracking
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		backtrack(res, new ArrayList<String>(), s, 0);
		return res;
	}

	private void backtrack(List<List<String>> res, List<String> list, String s, int start) {
		// Termination condition
		if (start >= s.length()) {
			res.add(new ArrayList<String>(list));
		}
		for (int i = start; i < s.length(); i++) {
			// Add in list only if palindrome.
			if (isPalindrome(s, start, i)) {
				list.add(s.substring(start, i + 1));
				backtrack(res, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int x, int y) {
		int p0 = (x + y) / 2;
		// start p1 from the second middle if length is even.
		int p1 = (y - x + 1) % 2 == 0 ? p0 + 1 : p0;

		while (p0 >= x && p1 <= y) {
			if (s.charAt(p0--) != s.charAt(p1++))
				return false;
		}
		return true;
	}
}
