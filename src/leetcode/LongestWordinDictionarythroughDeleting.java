package leetcode;

import java.util.List;

public class LongestWordinDictionarythroughDeleting {

	/*
	 * Given a string and a string dictionary, find the longest string in the
	 * dictionary that can be formed by deleting some characters of the given
	 * string. If there are more than one possible results, return the longest
	 * word with the smallest lexicographical order. If there is no possible
	 * result, return the empty string
	 */

	// O(n*x) where n is the dictionary size and x is the maximum length of
	public String findLongestWord(String s, List<String> d) {
		String maxLenStr = "";

		for (String str : d) {
			if (isSubsequence(s, str)) {
				// why str.compareTo < 0 because smallest lexicographical
				if (str.length() > maxLenStr.length()
						|| (str.length() == maxLenStr.length() && str.compareTo(maxLenStr) < 0)) {
					maxLenStr = str;
				}
			}
		}
		return maxLenStr;
	}

	public boolean isSubsequence(String s, String t) {
		// Looping the s.
		int j = 0;
		for (int i = 0; i < s.length() && j < t.length(); i++) {
			if (s.charAt(i) == t.charAt(j))
				j++;
		}
		return j == t.length();
	}

}
