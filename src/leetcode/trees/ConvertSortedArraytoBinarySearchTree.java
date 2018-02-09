package leetcode.trees;

public class ConvertSortedArraytoBinarySearchTree {

	/*
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 */

	// O(N) time, O(N) space if we considered the space cost of recursive calls.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return buildTree(nums, 0, nums.length - 1);
	}

	public TreeNode buildTree(int[] nums, int start, int end) {
		if (end < start)
			return null;
		int mid = (end + start) / 2;
		int val = nums[mid];

		TreeNode root = new TreeNode(val);
		root.left = buildTree(nums, start, mid - 1);
		root.right = buildTree(nums, mid + 1, end);

		return root;
	}

}
