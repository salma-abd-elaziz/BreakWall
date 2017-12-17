package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	// Using a heap.
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null)
			return null;
		Comparator<ListNode> comp = new Comparator<ListNode>() {
			public int compare(ListNode first, ListNode second) {
				return first.val - second.val;
			}
		};
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(comp);

		// Add the first elements in the heap.
		for (ListNode list : lists) {
			if (list != null)
				pq.add(list);
		}

		// Construct the big list.
		ListNode dummy = new ListNode(0);
		// Pointer node the move through the big list.
		ListNode point = dummy;

		while (!pq.isEmpty()) {
			ListNode n = pq.remove();
			// Add to the big list.
			point.next = n;
			point = point.next;

			// Add the nextNode to the queue.
			if (n.next != null)
				pq.add(n.next);
		}
		return dummy.next;
	}
}
