package leetcode.strings;


public class SubArrayContainsAnagram {

	/*
	 * Given 2 words, return true if second word has a substring that is also an
	 * anagram of word 1. t = LGE , s = GOOGLE- True GEO, GOOGLE - False
	 */
	
	public boolean containsAnagram(String s, String t) {
		int[] tmap = new int[26];
		for (char c : t.toCharArray())
			tmap[c - 'A']++;
		int p1 = 0, p2 = 0;
		int minimumLen = Integer.MAX_VALUE;
		int expandedLength = t.length();
		while (p1 < s.length() && p1 < s.length()) {
			if (tmap[s.charAt(p2++) - 'A']-- > 0) expandedLength--;
			while (expandedLength == 0) {
				if (p2 - p1 < minimumLen) {
					minimumLen = p2 - p1;
					if (minimumLen == t.length()) return true;
				}
				if (p1 >= s.length()) break;
				// Exists in t.
				if (tmap[s.charAt(p1++) - 'A']++ == 0) expandedLength++;
			}
		}
		return false;
	}
}
