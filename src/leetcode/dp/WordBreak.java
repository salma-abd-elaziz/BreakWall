package leetcode.dp;

import java.util.List;

public class WordBreak {

	/*
	 * Given a non-empty string s and a dictionary wordDict containing a list of
	 * non-empty words, determine if s can be segmented into a space-separated
	 * sequence of one or more dictionary words.
	 * 
	 * Note: 
	 * 1 - The same word in the dictionary may be reused multiple times in
	 * the segmentation. 
	 * 2 - You may assume the dictionary does not contain
	 * duplicate words.
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0 ; i < s.length(); i++) {
            if (dp[i]) {
                for (String word : wordDict) {
                    /* If the current word and other found words (excepressed by i) longer than s 
                    or this was found before continue */
                    if (i + word.length() > s.length() || dp[i + word.length()]) continue;
                    if(word.equals(s.substring(i, i + word.length()))) dp[i + word.length()] = true; 
                }
            }
        }
        return dp[s.length()];
    }
}
