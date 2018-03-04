package leetcode.mathANDnumbers;

public class NumberComplement {
	

	public int getComplement(int num) {
		return ~num & (Integer.highestOneBit(num) - 1);
	}
}
