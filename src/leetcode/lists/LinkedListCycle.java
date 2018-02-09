package leetcode.lists;

public class LinkedListCycle {
	/*
	 * Given a linked list, determine if it has a cycle in it.
	 * 
	 */

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (slow != null && fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast)
				return true;
		}
		return false;

	}
}
