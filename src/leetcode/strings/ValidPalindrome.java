package leetcode.strings;

public class ValidPalindrome {

	/*
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 */

	public boolean isPalindrome(String s) {
		// Remove the all not alphanumeric characters.
		String b = s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
		// loop from 0 to (size / 2) - 1
		for (int i = 0; i < b.length() / 2; i++) {
			if (b.charAt(i) != b.charAt(b.length() - i - 1))
				return false;
		}
		return true;
	}

	// another Solution because replaceAll may take much time;
	public boolean isPalindromeI(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) { 
			if (!Character.isLetterOrDigit(s.charAt(start)))
				start++;
			else if (!Character.isLetterOrDigit(s.charAt(end)))
				end--;
			else {
				if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
					return false;
				start++;
				end--;
			}
		}
		return true;
	}
}
