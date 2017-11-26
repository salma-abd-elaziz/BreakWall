package leetcode;

public class PowerofThree {
	/*
	 * Given an integer, write a function to determine if it is a power of
	 * three.
	 * 
	 */
	// Iterating.
	public boolean isPowerOfThree(int n) {
		if (n == 0)
			return false;

		while (n % 3 == 0) {
			n /= 3;
		}
		return n == 1;
	}

	/*
	 * Time limit Exceeded, because I keep checking until I reach n :/, while
	 * the previous solution we don't iterate if n is not a multiple by 3
	 */
	public boolean isPowerOfThreeI(int n) {
		int power = 1;

		while (n >= power) {
			if (n == power)
				return true;
			power *= 3;
		}

		return false;
	}

	/*
	 * Using the fact that 3 => 10 in base 3, 9 => 100 in base 3, 27 => 1000 in
	 * base 3, and so on, we can find n in base 3 , the check if it is 1
	 * followed by zero's
	 */
	// work with any base. 2, 4 ...
	public boolean isPowerOfThreeII(int n) {
		String str = Integer.toString(n, 3);
		return str.matches("^10*$"); // regex
		/*
		 * ^1 -> string starts with 1, 0* -> zero or more zero's, $ end of
		 * string
		 */
	}

}
