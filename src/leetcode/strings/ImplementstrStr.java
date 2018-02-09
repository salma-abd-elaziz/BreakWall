package leetcode.strings;

public class ImplementstrStr {
	/*
	 * Implement strStr().
	 * 
	 * Return the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 */

	// O(MN), where N and M are the sizes of the two strings.
	public int strStr(String haystack, String needle) {
		if (needle.length() > haystack.length())
			return -1;
		if (needle.length() < 1) // empty.
			return 0;
		// can be i <= haystack.length() - needle.length(), but this will not
		// work if the two strings are identical, ask your interviewer if the
		// strings could be identical or not, if not use the subtraction.
		for (int i = 0; i < haystack.length(); i++) {
			int j = 0;
			// Find first char in needle in haystack.
			if (haystack.charAt(i) == needle.charAt(j)) {
				int k = i + 1;
				for (j += 1; j < needle.length(); j++) {
					// We need to check if k in range because a match might
					// happen in end of the haystack like -> misa , ahhhh
					if (k >= haystack.length() || haystack.charAt(k++) != needle.charAt(j))
						break;
				}
				if (j == needle.length())
					return i;
			}
		}
		return -1;
	}

	public int strStrII(String haystack, String needle) {
		return haystack.indexOf(needle); // :"D
	}
}
