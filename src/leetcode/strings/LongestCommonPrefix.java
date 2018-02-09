package leetcode.strings;

public class LongestCommonPrefix {

	/*
	 * Write a function to find the longest common prefix string amongst an
	 * array of strings.
	 */
	// (N * S) where N is the number of Strings and S is the length of the
	// tallest string.
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length < 1)
			return ""; // error
		String temp = strs[0];
		for (int i = 1; i < strs.length; i++) {
			if (strs[i] == null || strs[i].length() < 1)
				return "";
			temp = LCD(temp, strs[i]);
		}
		return temp;
	}

	private String LCD(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < str1.length() && i < str2.length()) {
			if (str1.charAt(i) == str2.charAt(i))
				sb.append(str1.charAt(i++));
			else
				break;
		}
		return sb.toString();
	}

	// More optimized solution. less calculations
	// O(S) where S is the sum of all char's in the array
	public String longestCommonPrefixI(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = findMinLengthStr(strs);
		for (int i = 0; i < strs.length; i++)
			// if the prefix not at the start, remove the last char.
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

	private String findMinLengthStr(String[] strs) {
		String res = strs[0];
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].length() < res.length())
				res = strs[i];
		}
		return res;
	}

}
