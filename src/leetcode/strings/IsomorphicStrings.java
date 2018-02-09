package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	/*
	 * Given two strings s and t, determine if they are isomorphic.
	 * 
	 * Two strings are isomorphic if the characters in s can be replaced to get
	 * t.
	 * 
	 * All occurrences of a character must be replaced with another character
	 * while preserving the order of characters. No two characters may map to
	 * the same character but a character may map to itself.
	 * 
	 * For example, Given "egg", "add", return true.
	 * 
	 * Given "foo", "bar", return false.
	 * 
	 * Given "paper", "title", return true.
	 */

	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		// Key: char in s, value : mapping of char in s which char in t
		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				if (!map.containsValue(t.charAt(i)))
					map.put(s.charAt(i), t.charAt(i));
				else
					return false; // Mapping already exists.
			}
		}

		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) != map.get(s.charAt(i)))
				return false;
		}
		return true;
	}
}
