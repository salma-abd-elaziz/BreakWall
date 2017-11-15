package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigZagOrderTravers {

	/* Definition for a binary tree node. */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}
	/*  returns the zigzag level order traversal of its nodes' values.
	 * 
	 * @param root 
	 *		the root of the tree needed to be traversed.
	 *@return 
	 *	list of list where every list in the big list represent a level in
	 *   zigzag order.
	 * */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		List<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		boolean isleft = true;
		queue.add(root);
		queue.add(null); // Level is over.
		while (!queue.isEmpty()) {
			TreeNode x = queue.remove();
			if (x == null) {
				while (!stack.isEmpty()) {
					queue.add(stack.pop());
				}
				stack = new Stack<TreeNode>();
				queue.add(null); // New level.
				isleft = !isleft;
				result.add(list);
				list = new ArrayList<Integer>();
				if (queue.peek() == null)
					break; // The end.
			} else {
				list.add(x.val);
				// The current level is the reverse of the previous level,
				// so fill in the stack by the level of the previous, because it
				// will be reversed
				// when it is entered to the queue
				TreeNode first = isleft ? x.left : x.right;
				TreeNode second = isleft ? x.right : x.left;
				if (first != null)
					stack.add(first);
				if (second != null)
					stack.add(second);
			}
		}
		return result;
	}
}
