package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	/*
	 * Given a string, find the length of the longest substring without
	 * repeating characters.
	 * 
	 * Examples:
	 * 
	 * Given "abcabcbb", the answer is "abc", which the length is 3.
	 * 
	 * Given "bbbbb", the answer is "b", with the length of 1.
	 * 
	 * the idea here is the Length of the subString not the sub string itself.
	 */

	// Window (2 pointers) approach.
	/*
	 * What we need : 1 - 2 pointers 2 - data structure to hold the current
	 * substring, and to check if the nect char exists in it or not. the idea
	 * here is the Length of the subString not the sub strign itself.
	 */
	public int lengthOfLongestSubstring(String s) {
		int i = 0;
		int j = 0;
		int len = 0;
		// Set is the best use as a data structure as we need no repetition .
		Set<Character> set = new HashSet<Character>();
		while (j < s.length() && i < s.length()) {
			if (!set.contains(s.charAt(j))) { // O(n)
				set.add(s.charAt(j++));
				len = Math.max(len, j - i); // substring [i, j)
			} else { // Exists
				set.remove(s.charAt(i++));
			}
		}
		return len;
	}

	// HashTable approach

	public int lengthOfLongestSubstringI(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int len = 0;
		int i = 0;
		for (int j = 0; j < s.length(); j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			len = Math.max(len, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return len;
	}

}
