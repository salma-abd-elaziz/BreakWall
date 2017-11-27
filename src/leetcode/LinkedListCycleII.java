package leetcode;


public class LinkedListCycleII {

	/*
	 * Given a linked list, return the node where the cycle begins. If there is
	 * no cycle, return null.
	 */

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		boolean found = false;
		while (slow != null && fast != null && fast.next != null && !found) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				found = true;
		}

		if (!found)
			return null;
		fast = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
