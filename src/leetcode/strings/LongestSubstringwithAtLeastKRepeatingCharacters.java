package leetcode.strings;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

	/*
	 * Find the length of the longest substring T of a given string (consists of
	 * lowercase letters only) such that every character in T appears no less
	 * than k times.
	 */

	 public int longestSubstring(String s, int k) {
	        if (s == null ||s.length() < 1 || k < 1) return 0;
	        return helper(s.toCharArray(), 0, s.length(), k);
	    }
	    
	    public int helper(char[] strArr, int start, int end, int k) {
	        if (end - start < k) return 0;
	        
	        int[] map = new int[26];
	        for (int i = start; i < end; i++) map[strArr[i] - 'a']++;
	        
	        for (int i = 0; i < 26; i++) {
	            if (map[i] > 0 && map[i] < k){ // not long enough look left and right
	                for (int j = start; j < end; j++) {
	                    if (strArr[j] == i + 'a') //look for char i+'a' in range
	                        return Math.max(helper(strArr, start, j, k), helper(strArr, j + 1, end, k));
	                }
	            }
	        }
	        return end-start;
	    }
}
