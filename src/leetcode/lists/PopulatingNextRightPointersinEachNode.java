package leetcode.lists;

public class PopulatingNextRightPointersinEachNode {

	/*
	 * Populate each next pointer to point to its next right node. If there is
	 * no next right node, the next pointer should be set to NULL.
	 */

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	// O(n) time , O(1) space
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode head = root;
		while (head != null) {
			TreeLinkNode cur = head;
			while (cur != null) {
				// Set the left child's next.
				if (cur.left != null)
					cur.left.next = cur.right;
				// set the right child's next.
				if (cur.next != null && cur.right != null)
					cur.right.next = cur.next.left;
				cur = cur.next;
			}
			head = head.left;
		}
	}
}
