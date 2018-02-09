package leetcode.lists;

public class IntersectionofTwoLinkedLists {

	/*
	 * Write a program to find the node at which the intersection of two singly
	 * linked lists begins.
	 */

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA;
		ListNode b = headB;
		// Get the sizes.
		int aSize = 0;
		int bSize = 0;
		while (a != null) {
			aSize++;
			a = a.next;
		}
		while (b != null) {
			bSize++;
			b = b.next;
		}

		ListNode longer = aSize > bSize ? headA : headB;
		ListNode shorter = aSize > bSize ? headB : headA;

		int diff = Math.abs(aSize - bSize);
		// Move the longer Linked list by the difference.
		while (diff != 0) {
			longer = longer.next;
			diff--;
		}
		// Start walking through the two linked lists and compare.
		while (longer != null && shorter != null) {
			if (longer == shorter) return shorter;
			longer = longer.next;
			shorter = shorter.next;
		}
		return null;
	}
}
