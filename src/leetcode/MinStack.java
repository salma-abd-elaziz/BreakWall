package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

	/*
	 * Design a stack that supports push, pop, top, and retrieving the minimum
	 * element in constant time.
	 * 
	 * push(x) -- Push element x onto stack. pop() -- Removes the element on top
	 * of the stack. top() -- Get the top element. getMin() -- Retrieve the
	 * minimum element in the stack.
	 */

	/** initialize your data structure here. */
	List<Integer> st;
	List<Integer> minHistory;

	public MinStack() {
		st = new ArrayList<Integer>();
		minHistory = new ArrayList<Integer>();
	}

	public void push(int x) {
		st.add(x);
		// Update min if needed.
		if (minHistory.isEmpty())
			minHistory.add(x);
		else {
			int minimum = minHistory.get(minHistory.size() - 1);
			if (minimum >= x)
				minHistory.add(x);
		}
	}

	public void pop() {
		if (st.isEmpty())
			return;
		int top = st.remove(st.size() - 1);
		int minimum = minHistory.get(minHistory.size() - 1);
		if (top == minimum)
			minHistory.remove(minHistory.size() - 1);
	}

	public int top() {
		if (st.isEmpty())
			return Integer.MIN_VALUE;
		return st.get(st.size() - 1);
	}

	public int getMin() {
		if (minHistory.isEmpty())
			return Integer.MIN_VALUE;
		return minHistory.get(minHistory.size() - 1);
	}
}
