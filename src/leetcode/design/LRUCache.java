package leetcode.design;

import java.util.*;

public class LRUCache {

	/*
	 * Design and implement a data structure for Least Recently Used (LRU)
	 * cache. It should support the following operations: get and put.
	 * 
	 * get(key) - Get the value (will always be positive) of the key if the key
	 * exists in the cache, otherwise return -1. put(key, value) - Set or insert
	 * the value if the key is not already present. When the cache reached its
	 * capacity, it should invalidate the least recently used item before
	 * inserting a new item.
	 */
	
	private class MapValue {
		private int val; // The value of a key.
		private double usedAt; // Last time it was used.

		public MapValue(int val, double d) {
			this.val = val;
			this.usedAt = d;
		}

		public void setUsedAt(double d) {
			this.usedAt = d;
		}

		public void setValue(int val) {
			this.val = val;
		}
	}

	private int capacity;
	private double currentIndex = 0;
	private Map<Integer, MapValue> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, MapValue>();
	}

	// O(1)
	public int get(int key) {
		if (map.containsKey(key)) {
			(map.get(key)).setUsedAt(currentIndex++);
			return map.get(key).val;
		}
		return -1;
	}

	
	// O(capacity)
	public void put(int key, int value) {
		// do we need to handle insertion of already exists key?
		// yes just replace the value and update usedAt.
		if (map.containsKey(key)) {
			(map.get(key)).setValue(value);
			(map.get(key)).setUsedAt(currentIndex++);
			return;
		}

		if (map.size() == capacity) {
			double minimum = Double.POSITIVE_INFINITY;
			int minKey = 0;

			for (Map.Entry<Integer, MapValue> e : map.entrySet()) {
				// Find LRU.
				if (e.getValue().usedAt < minimum) {
					minimum = e.getValue().usedAt;
					minKey = e.getKey();
				}
			}
			map.remove(minKey);
		}
		map.put(key, new MapValue(value, currentIndex++));
	}
}
