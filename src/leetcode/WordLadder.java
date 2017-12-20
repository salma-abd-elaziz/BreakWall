package leetcode;

import java.util.HashSet;
import java.util.*;

public class WordLadder {

	/*
	 * Given two words (beginWord and endWord), and a dictionary's word list,
	 * find the length of shortest transformation sequence from beginWord to
	 * endWord, such that:
	 * 
	 * Only one letter can be changed at a time. Each transformed word must
	 * exist in the word list. Note that beginWord is not a transformed word.
	 * For example,
	 * 
	 * Given: beginWord = "hit" endWord = "cog" wordList =
	 * ["hot","dot","dog","lot","log","cog"] As one shortest transformation is
	 * "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
	 */

	// Assuming only [a-z] character Strings.
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (wordList == null || wordList.size() < 1 || beginWord.length() != endWord.length())
			return 0;
		if (beginWord.equals(endWord))
			return 1;

		Set<String> wordList1 = new HashSet<String>(wordList);
		int len = 2; // the start and end 2 steps.

		// BFs.
		Queue<String> queue = new LinkedList<String>();
		addNeighbors(beginWord, queue, wordList1);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String str = queue.remove();
				if (str.equals(endWord))
					return len;
				addNeighbors(str, queue, wordList1);
			}
			len++; // Step
		}
		// Not Found.
		return 0;
	}

	// Add to the queue all the words that is one letter away from str.
	private void addNeighbors(String str1, Queue<String> queue, Set<String> wordList) {
		// For each letter try to change it with all other litters.
		StringBuilder str = new StringBuilder(str1);
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			for (int j = 0; j < 26; j++) {
				str.setCharAt(i, (char) (j + 'a'));
				if (wordList.contains(str.toString())) {
					queue.add(str.toString());
					wordList.remove(str.toString());
				}
			}
			str.setCharAt(i, c);
		}
	}
}
