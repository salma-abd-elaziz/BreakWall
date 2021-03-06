package leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardGame {

	/*
	 * Michelle has created a word game for her students. The word game begins
	 * with Michelle writing a string and a number, K, on the board. The
	 * students must find a substring of size K such that there is exactly one
	 * character that is repeated one; in other words, there should be k - 1
	 * distinct characters in the substring.
	 * 
	 * Write an algorithm to help the students find the correct answer. If no
	 * such substring can be found, return an empty list; if multiple such
	 * substrings exist, return all them, without repetitions. The order in
	 * which the substrings are does not matter.
	 * 
	 * Input: The input to the function/method consists of two arguments -
	 * inputString, representing the string written by the teacher; num an
	 * integer representing the number, K, written by the teacher on the board.
	 * 
	 * Output: Return a list of all substrings of inputString with K characters,
	 * that have k-1 distinct character i.e. exactly one character is repeated,
	 * or an empty list if no such substring exist in inputString. The order in
	 * which the substrings are returned does not matter.
	 * 
	 * Constraints: The input integer can only be greater than or equal to 0 and
	 * less than or equal to 26 (0 <= num <= 26) The input string consists of
	 * only lowercase alphabetic characters.
	 * 
	 * Example Input: inputString = awaglk num = 4
	 * 
	 * Output: [awag]
	 * 
	 * Explanation: The substrings are {awag, wagl, aglk} The answer is awag as
	 * it has 3 distinct characters in a string of size 4, and only one
	 * character is repeated twice.
	 */
	// O(NK) time, O(K) space => constant
	public List<String> playGame(String str, int k) {
		List<String> res = new ArrayList<String>();
		if (str.length() - k < 0) return res;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		// O(N)
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);

			if (i >= k) {
				// Remove first char from that window
				if (map.get(str.charAt(i - k)) - 1 == 0)
					map.remove(str.charAt(i - k));
				else
					map.put(str.charAt(i - k), map.get(str.charAt(i - k)) - 1);
			}
			if (i >= k - 1) {
				// A window is reached check it.
				boolean duplicateFound = false, duplicateFoundTwice = false;
				// O(K)
				for (Map.Entry<Character, Integer> e : map.entrySet()) {
					if (e.getValue() > 1 && duplicateFound) {
						duplicateFoundTwice = true;
						break;
					} else if (e.getValue() > 1 && !duplicateFound)
						duplicateFound = true;
				}
				if (duplicateFound && !duplicateFoundTwice)
					res.add(str.substring(i - k + 1, i + 1));
			}
		}
		return res;
	}

}
