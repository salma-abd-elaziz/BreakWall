package leetcode;

public class AddTwoNumbers {
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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbers(l1, l2, 0);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0)
			return null;
		ListNode result = new ListNode(0);
		int sum = carry;
		// set values.
		if (l1 != null)
			sum += l1.val;
		if (l2 != null)
			sum += l2.val;
		result.val = sum % 10;
		// Recurse.
		// The condition is on l1 and l2 to be able to recurse even when the
		// nexts are null but there is a carry still.
		if (l1 != null || l2 != null) {
			ListNode next = addTwoNumbers(l1 != null ? l1.next : null, l2 != null ? l2.next : null, sum >= 10 ? 1 : 0);
			result.next = next;
		}

		return result;
	}
}
