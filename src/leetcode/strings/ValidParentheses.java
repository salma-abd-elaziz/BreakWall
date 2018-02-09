package leetcode.strings;

import java.util.Stack;

public class ValidParentheses {

	/*
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 */
	
	public boolean isValid(String s) {
		// Stack will have the opening.
		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
				st.push(s.charAt(i));
			else {
				if (st.isEmpty())
					return false;
				char lookFor = st.pop();
				if (lookFor != '{' && s.charAt(i) == '}')
					return false;
				else if (lookFor != '(' && s.charAt(i) == ')')
					return false;
				else if (lookFor != '[' && s.charAt(i) == ']')
					return false;
			}
		}
		return st.isEmpty();
	}
}
