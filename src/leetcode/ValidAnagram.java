package leetcode;

import java.util.Arrays;

public class ValidAnagram {
	
	/*
	 * Given two strings s and t, write a function to determine if t is an
	 * anagram of s.
	 */

	// O(NlogN) time, O(N) space.
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		Arrays.sort(sArray);
		Arrays.sort(tArray);

		for (int i = 0; i < sArray.length; i++) {
			if (sArray[i] != tArray[i])
				return false;
		}
		return true;
	}

}
