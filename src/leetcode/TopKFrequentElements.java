package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// To know the bucket array size.
		int maxFrequency = Integer.MIN_VALUE;
		for (int n : nums) {
			int frequency = map.getOrDefault(n, 0) + 1;
			map.put(n, frequency);
			// Update maxFrequency.
			if (maxFrequency < frequency)
				maxFrequency = frequency;
		}

		@SuppressWarnings("unchecked")
		List<Integer>[] bucket = new List[maxFrequency + 1];

		// Fill buckets.
		for (int key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null)
				bucket[frequency] = new ArrayList<Integer>();
			bucket[frequency].add(key);
		}

		// Concatenate buckets.
		for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
			if (bucket[i] != null)
				result.addAll(bucket[i]);
		}

		// Return only k elements as the list might be more than k.
		return result.subList(0, k);
	}
}
