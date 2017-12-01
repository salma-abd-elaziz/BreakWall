package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWhichContains2UniqueCharacters {

	/*
	 * Given a string, find the longest substring that contains only two unique
	 * characters. For example, given "abcbbbbcccbdddadacb", the longest
	 * substring that contains 2 unique character is "bcbbbbcccb".
	 * 
	 */
	
	public int longestSubstringWithKUniqueChacaters(String s, int k) {
		if(s == null || s.length() < 1 || k < 1) return 0;
		// key : char in s, value: repetitions 
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int maxLen = Integer.MIN_VALUE;
		
		for (int i = 0;i < s.length(); i++) {
			
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			
			if (map.size() > k) {
				maxLen = Math.max(maxLen, i - left);
				// Keep moving to right till you remove the extra char.
				while (map.size() > k) {
					char fc = s.charAt(left);
					if (map.get(fc) > 1) map.put(fc, map.get(fc) - 1);
					else map.remove(fc);
					left++;
				}
			}
		}
		return Math.max(maxLen, s.length() - left);
	}
}
