package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScenesPartitioning {

	/*
	 * Write a function which will partition a sequence of labels into minimal
	 * subsequences so that no labels appear in more than one subsequence. The
	 * output should be the length of each subsequence.
	 * 
	 * Input: The input to the function/method consists of an argument -
	 * inputList, a list of characters representing the sequence of shots.
	 * 
	 * Output: Return a list of integers representing the length of each scene,
	 * in the order in which it appears in the given sequence of shots.
	 * 
	 * Example:
	 * 
	 * Input: inputList = [a,b,a,b,c,b,a,c,a,d,e,f,e,g,d,e,h,i,j,h,k,l,i,j]
	 * Output: [9, 7, 8] Explanation: The correct partitioning is:
	 * a,b,a,b,c,b,a,c,a,/d,e,f,e,g,d,e,/h,i,j,h,k,l,i,j To ensure that no label
	 * appears in more than one subsequence, subsequences are as small as
	 * possible, and subsequences partition the sequence. The length of these
	 * subsequences are 9, 7 and 8.
	 */

	// O(N) time, O(1) space
	public List<Integer> videoParition(char[] shots) {
		// The lengths list
		List<Integer> res = new ArrayList<Integer>();
		if (shots == null)
			return res;
		// Each label appeared how many times.
		/*
		 * With the assumption that the shots is represented as chars(Alphabets [a-z]) 
		 * the extra space will be order 1, if all char set is allowed space is
		 * O(b), where b is the char set size
		 */
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : shots) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int start = 0;
		int end = 0;
		while (start < shots.length && end < shots.length) {
			Map<Character, Integer> localMap = new HashMap<Character, Integer>();
			// Find a partition.
			do {
				char c = shots[end++];
				if (!localMap.containsKey(c)) {
					int toAddCount = map.get(c) - 1;
					if (toAddCount > 0)
						localMap.put(c, toAddCount);
					// Remove from Original map.
					map.remove(c);
				} else {
					int toAddCount = localMap.get(c) - 1;
					if (toAddCount == 0)
						localMap.remove(c);
					else
						localMap.put(c, toAddCount);
				}
			} while (localMap.size() > 0 && end < shots.length);
			// Add that partition length.
			res.add(end - start);
			// Update start to get the next partition.
			start = end;
		}
		return res;
	}
}
