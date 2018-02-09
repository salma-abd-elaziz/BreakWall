package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	/*
	 * Given a string S and a string T, find the minimum window in S which will
	 * contain all the characters in T in complexity O(n).
	 * 
	 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
	 */

	public String minWindow(String s, String t) {
		// key : letter, value: number of times it appears in the string.
		Map<Character, Integer> tmap = new HashMap<Character, Integer>();
		Map<Character, Integer> smap = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			tmap.put(c, tmap.getOrDefault(c, 0) + 1);
		}
		String res = "";
		int begin = 0;
		int minLen = Integer.MAX_VALUE;
		int expandedLen = 0;
		for (int i = 0; i < s.length(); i++) {
			// s[i] exists in t.
			if (tmap.containsKey(s.charAt(i))) {
				if (smap.containsKey(s.charAt(i))) {
					// Use the char from s in t
					if (smap.get(s.charAt(i)) < tmap.get(s.charAt(i)))
						expandedLen++;
					smap.put(s.charAt(i), smap.get(s.charAt(i)) + 1);
				} else {
					smap.put(s.charAt(i), 1);
					expandedLen++;
				}
			}
			// Found a match.
			if (expandedLen == t.length()) {
				// find the start
				char c = s.charAt(begin);
				while (!smap.containsKey(c) || smap.get(c) > tmap.get(c)) {
					if (smap.containsKey(c)) {
						smap.put(c, smap.get(c) - 1);
					}
					c = s.charAt(++begin);
				}
				// Update minLen
				if (i - begin + 1 < minLen) {
					minLen = i - begin + 1;
					res = s.substring(begin, i + 1); // char at i included.
				}
			}
		}
		return res;
	}

	// Not Working
	public String minWindowI(String s, String t) {
		// Alphabetic [A-z, a-z].
		int[] map = new int[128];
        String res = "";
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int p1 = 0, p2 = 0;
        int expandedLen = t.length();
        char[] sArr = s.toCharArray();
        for (char c : t.toCharArray()) map[c - 'A']++;
        
        while(p2 < s.length() && p1 < s.length()){
            if (map[sArr[p2++] - 'A']-- > 0) expandedLen--;
            while (expandedLen == 0) {
                if (p2 - p1 < minLen) {
                    start = p1;
                    minLen = p2 - p1;
                    res = s.substring(start, p2);
                }
                if (p1 >= s.length()) break;
                // Find the next start.
                if (map[sArr[p1++] - 'A']++ == 0 ) expandedLen++;
            }
        }
        return res;
    }
}
