package leetcode.strings;

import java.util.*;

public class MinimumGeneticMutation {
	public int minMutation(String start, String end, String[] bank) {
		if (bank == null || bank.length < 1 || start.length() != end.length() || end.length() < 1)
			return -1; // error.

		Set<String> bank1 = new HashSet<String>(Arrays.asList(bank));
		// Add the end to the dictionary.
		int len = 1; // the start and end 2 steps.

		// BFs.
		Queue<String> queue = new LinkedList<String>();
		addNeighbors(start, queue, bank1);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String str = queue.remove();
				if (str.equals(end))
					return len;
				addNeighbors(str, queue, bank1);
			}
			len++; // Step
		}
		// Not Found.
		return -1;
	}

	// Add to the queue all the words that is one letter away from str.
	private void addNeighbors(String str1, Queue<String> queue, Set<String> bank) {
		// For each letter try to change it with all other litters.
		StringBuilder str = new StringBuilder(str1);
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			for (int j = 0; j < 26; j++) {
				str.setCharAt(i, (char) (j + 'A'));
				if (bank.contains(str.toString())) {
					queue.add(str.toString());
					bank.remove(str.toString());
				}
			}
			str.setCharAt(i, c);
		}
	}

}