package leetcode;

import java.util.Stack;

import leetcode.LinkedListCycleII.ListNode;

public class PalindromeLinkedList {
	/* Given a singly linked list, determine if it is a palindrome. */

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

	}
	
	// O(N) time, O(N) space
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		Stack<Integer> st = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			st.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		// Even.
		if (fast != null) {
			slow = slow.next;
		}

		while (!st.isEmpty()) {
			if (st.pop() != slow.val)
				return false;
			slow = slow.next;
		}
		return true;
	}
	
	

}
