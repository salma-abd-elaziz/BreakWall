package leetcode.lists;

public class ReversLinkedlist {

	/* Reverse a singly linked list. */
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	// O(N) time
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

}
