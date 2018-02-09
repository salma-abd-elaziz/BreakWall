package leetcode.arrays;

public class PlusOne {
	/*
	 * Given a non-negative integer represented as a non-empty array of digits,
	 * plus one to the integer.
	 * 
	 * You may assume the integer do not contain any leading zero, except the
	 * number 0 itself.
	 * 
	 * The digits are stored such that the most significant digit is at the head
	 * of the list.
	 */

	public int[] plusOne(int[] digits) {
		int[] result = new int[digits.length];

		int carry = 1;
		int index = digits.length - 1;

		while (index >= 0) {
			result[index] = (digits[index] + carry) % 10;
			carry = (digits[index] + carry) > 9 ? 1 : 0;
			index--;
		}

		// We need to add more digit.
		if (carry > 0) {
			int[] result1 = new int[digits.length + 1];
			for (int i = digits.length - 1; i >= 0; i--) {
				result1[i + 1] = result[i];
			}
			result1[0] = 1;
			return result1;
		}

		return result;
	}
}
