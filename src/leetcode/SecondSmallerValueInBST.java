package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SecondSmallerValueInBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * Here we need to ask if duplicates are allowed or not as here the
	 * duplicates are allowed, if not we could returned the parent of the most
	 * left element in the tree.
	 */ public int findSecondMinimumValue(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inOrdertraverse(list, root);
		int count = 1;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) != list.get(i - 1))
				count++;
			if (count == 2)
				return list.get(i);
		}
		return -1;
	}

	public void inOrdertraverse(List<Integer> list, TreeNode root) {
		if (root == null)
			return;
		inOrdertraverse(list, root.left);

		list.add(root.val);

		inOrdertraverse(list, root.right);
	}

}
