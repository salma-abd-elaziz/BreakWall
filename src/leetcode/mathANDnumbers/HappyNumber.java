package leetcode.mathANDnumbers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	/*
	 * Write an algorithm to determine if a number is "happy".
	 * 
	 * A happy number is a number defined by the following process: Starting
	 * with any positive integer, replace the number by the sum of the squares
	 * of its digits, and repeat the process until the number equals 1 (where it
	 * will stay), or it loops endlessly in a cycle which does not include 1.
	 * Those numbers for which this process ends in 1 are happy numbers.
	 */

	// O(N) spqce
	public boolean isHappy(int num) {
		Set<Integer> set = new HashSet<Integer>();
		while (set.add(num)) {
			int sum = 0;
			while (num != 0) {
				int mod = num % 10;
				sum += mod * mod;
				num /= 10;
			}
			if (sum == 1)
				return true;
			num = sum;
		}
		return false;
	}
}
