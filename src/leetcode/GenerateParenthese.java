package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthese {

	/*
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 */

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		generateParenthesis(result, new StringBuilder(), 0, 0, n);
		return result;
	}

	public void generateParenthesis(List<String> result, StringBuilder sb, int open, int close, int n) {
		if (sb.length() == n * 2) { // One String is completed.
			result.add(sb.toString());
			return;
		}

		if (open < n) {
			sb.append("(");
			generateParenthesis(result, sb, open + 1, close, n);
			// reset the string when we are back from recursive call.
			sb.setLength(sb.length() - 1);
		}
		/*
		 * not close < n, because in this case we can add close n time while
		 * open = 1, 2,..., n-1. So we can close a parentheses that is not
		 * opened yet
		 */
		if (close < open) {
			sb.append(")");
			generateParenthesis(result, sb, open, close + 1, n);
			// reset the string when we are back from recursive call.
			sb.setLength(sb.length() - 1);
		}

	}
}
