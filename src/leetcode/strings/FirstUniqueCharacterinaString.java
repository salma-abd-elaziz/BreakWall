package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {

	/*
	 * Given a string, find the first non-repeating character in it and return
	 * it's index. If it doesn't exist, return -1.
	 */
	
	/*O(N) time, O(N) space */
	public int firstUniqCharI(String s) {
		if (s.length() == 0)
			return -1; // doesn't exists.
		else if (s.length() == 1)
			return 0;

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;
	}
}
