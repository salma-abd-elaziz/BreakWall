package leetcode;

import java.util.Stack;

public class ReorderList {

	/*
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
	 * L0→Ln→L1→Ln-1→L2→Ln-2→…
	 */

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// O(N) time, O(N) space.
	public void reorderList(ListNode head) {
		if (head == null)
			return;
		ListNode fast = head;
		ListNode mid = head;
		Stack<ListNode> st = new Stack<ListNode>();

		// Stop reordering when you read the middle node so find the middle node
		while (fast != null && fast.next != null) {
			mid = mid.next;
			fast = fast.next.next;
		}
		ListNode node = mid.next;

		while (node != null) {
			st.push(node);
			node = node.next;
		}

		node = head;
		while (!st.isEmpty()) {
			insert(node, st.pop());
			node = node.next.next;
		}
		mid.next = null;
	}

	// insert next to the next of the node.
	private void insert(ListNode node, ListNode next) {
		ListNode temp = node.next;
		node.next = next;
		next.next = temp;
	}
}
