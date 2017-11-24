package leetcode;

public class MergeTwoSortedArrays {
	/**
	 * Definition for singly-linked list.
	 */
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) return null;
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		ListNode smaller = l1.val < l2.val ? l1 : l2;
		ListNode bigger = l1.val < l2.val ? l2 : l1;

		while (smaller != null && bigger != null) {
			// Find the place of the bigger.
			while (smaller.next != null && smaller.next.val < bigger.val) {
				smaller = smaller.next;
			}

			ListNode i = smaller.next;
			// Add node.
			smaller.next = bigger;

			if (i != null) {
				smaller = i.val < bigger.val ? i : bigger;
				bigger = i.val < bigger.val ? bigger : i;
			} else {
				smaller = null;
			}
		}
		// Remember this condition must be like the smaller condition up there.
		return l1.val < l2.val ? l1 : l2;
	}

}
