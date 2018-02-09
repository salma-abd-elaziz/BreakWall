package leetcode;

public class MaximumBinaryTree {

	/*
	 * Given an integer array with no duplicates. A maximum tree building on
	 * this array is defined as follow:
	 * 
	 * The root is the maximum number in the array. The left subtree is the
	 * maximum tree constructed from left part subarray divided by the maximum
	 * number. The right subtree is the maximum tree constructed from right part
	 * subarray divided by the maximum number. Construct the maximum tree by the
	 * given array and output the root node of this tree.
	 */

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// O(N^2) time at the worst case, in case of the array is ordered, O(NlogN) on average
	// O(N) space in worst case and O(logN) ion average {recursive calls}.
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null || nums.length < 1)
			return null;
		return constructMaximumBinaryTree(nums, 0, nums.length);
	}

	private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
		if (start >= end)
			return null;
		int maxElemIndex = findMaximum(nums, start, end);
		TreeNode root = new TreeNode(nums[maxElemIndex]);
		root.left = constructMaximumBinaryTree(nums, start, maxElemIndex);
		root.right = constructMaximumBinaryTree(nums, maxElemIndex + 1, end);
		return root;
	}

	private int findMaximum(int[] nums, int start, int end) {
		int maxIndex = start;
		for (int i = start + 1; i < end; i++) {
			if (nums[i] > nums[maxIndex])
				maxIndex = i;
		}
		return maxIndex;

	}
}
