package leetcode;

public class OddEvenLinkedlist {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/*
	 * Given a singly linked list, group all odd nodes together followed by the
	 * even nodes. Please note here we are talking about the node number and not
	 * the value in the nodes.
	 * (Node NUMBER not value)
	 * O(N) time, O(N space)
	 */
	public ListNode oddEvenListI(ListNode head) {
		if (head == null)
			return null;
		ListNode oddhead = new ListNode(head.val);

		if (head.next == null)
			return head; // one element.
		ListNode evenhead = new ListNode(head.next.val);

		ListNode even = evenhead;
		ListNode odd = oddhead;

		ListNode n = head.next.next;

		while (n != null) {
			odd.next = new ListNode(n.val);
			odd = odd.next;
			n = n.next;
			if (n != null) {
				even.next = new ListNode(n.val);
				even = even.next;
				n = n.next;
			}
		}
		odd.next = evenhead;
		return oddhead;
	}

	// to swap the odd and even value nodes.
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return null;
		ListNode pe = head;
		ListNode po = null;

		ListNode rnhead = head;
		// Find first odd element.
		while (rnhead != null && rnhead.val % 2 != 1)
			rnhead = rnhead.next;

		// No odd value node.
		if (rnhead == null)
			return head;

		while (pe != null) {
			// Find even value node.
			while (pe.next != null && pe.next.val % 2 == 1)
				pe = pe.next;
			po = pe;
			// Find odd value node.
			while (po.next != null && po.next.val % 2 == 0)
				po = po.next;

			// swap consecutive elements.
			if (pe.next != null && pe.next == po)
				swapCon(pe);
			else if (pe.next != null && po.next != null)
				swap(pe, po);

		} // if odd
		return rnhead;

	}

	// swap consecutive nodes.
	public void swapCon(ListNode pe) {
		ListNode i = pe.next;
		ListNode j = i.next;

		pe.next = j;
		i.next = j.next;
		j.next = i;
	}

	// Swap not consecutive nodes.
	public void swap(ListNode pe, ListNode po) {
		ListNode i = pe.next;
		ListNode j = po.next;

		pe.next = j;
		po.next = i;
		ListNode w = i.next;
		i.next = j.next;
		j.next = w;
	}

}
