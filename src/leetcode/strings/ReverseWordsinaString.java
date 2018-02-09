package leetcode.strings;

public class ReverseWordsinaString {

	/*
	 * Given an input string, reverse the string word by word. A word is defined
	 * as a sequence of non-space characters.
	 * 
	 * The input string does not contain leading or trailing spaces and the
	 * words are always separated by a single space. if not you need to go
	 * through the string and remove the extra spaces.
	 * 
	 * For example, Given s = "the sky is blue", return "blue is sky the".
	 */

	public String reverseWords(String s) {
		// first we reverse each word then
		char[] charArr = s.toCharArray();
		int start = 0;
		for (int i = 1; i < charArr.length; i++) {
			if (charArr[i] == ' ') {
				reverse(charArr, start, i - 1);
				start = i + 1;
			}
		}

		// reverse last word as it dosn't reversed because a space dosn't follow
		// it.
		reverse(charArr, start, charArr.length - 1);
		// Reverse the whole sentence.
		reverse(charArr, 0, charArr.length - 1);
		return new String(charArr);

	}

	private void reverse(char[] charArr, int start, int end) {
		while (start < end) {
			char temp = charArr[start];
			charArr[start] = charArr[end];
			charArr[end] = temp;
			start++;
			end--;
		}
	}
	// To remove extra spaces
	 private String cleanSpaces(char[] s) {
	        int p1 = 0;
	        int p2 = 0;
	        while (p1 < s.length) {
	            while (p1 < s.length && s[p1] == ' ') p1++;
	            while (p1 < s.length && s[p1] != ' ') s[p2++] = s[p1++];
	            while (p1 < s.length && s[p1] == ' ') p1++;
	            if (p1 < s.length) s[p2++] = ' '; // but one space.
	        }
	        
	        return new String(s).substring(0, p2);
	    }
}
