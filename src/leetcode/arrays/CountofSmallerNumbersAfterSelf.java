package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountofSmallerNumbersAfterSelf {

	/*
	 * You are given an integer array nums and you have to return a new counts
	 * array. The counts array has the property where counts[i] is the number of
	 * smaller elements to the right of nums[i].
	 */

	// Brute Force O(n^2)
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<Integer>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			res.add(countSmaller(nums, i));
		}
		return res;
	}

	private int countSmaller(int[] nums, int index) {
		int num = nums[index];
		int count = 0;
		for (int i = index + 1; i < nums.length; i++) {
			if (nums[i] < num)
				count++;
		}
		return count;
	}

	private class BSTNode {
		BSTNode left, right;
		int val;
		int dup = 1;
		int leftCount; //

		public BSTNode(int v, int count) {
			this.val = v;
			this.leftCount = count;
		}
	}

	// O(nlogn) 
	public List<Integer> countSmallerI(int[] nums) {
		Integer[] res = new Integer[nums.length];
		BSTNode root = null;
		// O(n)
		for (int i = nums.length - 1; i >= 0; i--) {
			root = helper(nums[i], i, res, 0, root);
		}
		return Arrays.asList(res);
	}

	// count is the number of smaller elements after me.
	// O(logn) in balanced tree.
	private BSTNode helper(int num, int index, Integer[] res, int count, BSTNode node) {
		if (node == null) {
			// no left nodes yet so leftCount = 0.
			node = new BSTNode(num, 0);
			res[index] = count;
		} else if (node.val == num) { // dup
			node.dup++;
			// count calculated by the recursion(2, 3) and the leftCount(1), ex
			// : [1, 4, (2, 3), 4, (1)]
			res[index] = node.leftCount + count;
		} else if (node.val > num) { // left
			node.leftCount++;
			node.left = helper(num, index, res, count, node.left);
		} else {
			// Update the count.
			node.right = helper(num, index, res, count + node.dup + node.leftCount, node.right);
		}
		return node;
	}

}
