package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	/*
	 * Given two strings s and t, write a function to determine if t is an
	 * anagram of s.
	 */

	// O(NlogN) time, O(N) space.
	public boolean isAnagramI(String s, String t) {
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

	// O(N) time, O(N) space
	public boolean isAnagramII(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) - 1);
		}

		for (int val : map.values()) {
			if (val != 0)
				return false;
		}
		return true;
	}
}
