package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII {

	/* Given two arrays, write a function to compute their intersection. */

	/* O(N + M) time, O(max(N , M)) space, HashMap solution */
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length <= 0)
			return nums1;
		if (nums2.length <= 0)
			return nums2;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		List<Integer> list = new ArrayList<Integer>();
		int[] longer = nums1.length > nums2.length ? nums1 : nums2;
		int[] shorter = nums1.length > nums2.length ? nums2 : nums1;

		// Fill Map.
		for (int num : longer) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// Find common elements.
		for (int num : shorter) {
			if (map.getOrDefault(num, 0) > 0) {
				list.add(num);
				map.put(num, map.get(num) - 1);
			}
		}
		// Copy list.
		int[] result = new int[list.size()];
		int i = 0;
		for (int num : list) {
			result[i++] = num;
		}
		return result;
	}

	// Sort and Two Pointers O(NlogN) time, O(1) space.
	public int[] intersectI(int[] nums1, int[] nums2) {

		if (nums1.length <= 0)
			return nums1;
		if (nums2.length <= 0)
			return nums2;

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		List<Integer> list = new ArrayList<Integer>();
		int index1 = 0;
		int index2 = 0;

		while (index1 < nums1.length && index2 < nums2.length) {
			if (nums1[index1] < nums2[index2])
				index1++;
			else if (nums2[index2] < nums1[index1])
				index2++;
			else {
				list.add(nums1[index1]);
				index1++;
				index2++;
			}
		}

		// Copy list.
		int[] result = new int[list.size()];
		int i = 0;
		for (int num : list) {
			result[i++] = num;
		}
		return result;
	}
}
