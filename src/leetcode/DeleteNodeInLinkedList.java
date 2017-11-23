package leetcode;

public class DeleteNodeInLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public void deleteNode(ListNode node) {
		if (node == null)
			return;
		// Copy the data from this node to the next, then delete the next node.
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
	}
}
