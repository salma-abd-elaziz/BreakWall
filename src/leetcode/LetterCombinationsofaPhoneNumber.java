package leetcode;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

	/*
	 * Given a digit string, return all possible letter combinations that the
	 * number could represent.
	 * 
	 * A mapping of digit to letters (just like on the telephone buttons) is
	 * given below.
	 */

	private Map<Integer, String> map;

	public LetterCombinationsofaPhoneNumber() {
		map = new HashMap<Integer, String>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
	}

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if (digits == null || digits.length() < 1)
			return res;
		backtracking(res, new StringBuilder(), digits, 0);
		return res;
	}

	private void backtracking(List<String> res, StringBuilder cur, String digits, int digitsIndex) {
		if (cur.length() == digits.length()) {
			res.add(new String(cur));
			return;
		}

		String letters = map.getOrDefault(Character.getNumericValue(digits.charAt(digitsIndex)), "");
		for (int j = 0; j < letters.length(); j++) {
			cur.append(letters.charAt(j));
			backtracking(res, cur, digits, digitsIndex + 1);
			cur.setLength(cur.length() - 1);

		}
	}
}
