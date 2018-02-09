package leetcode.mathANDnumbers;

public class CountPrimes {

	/*
	 * Count the number of prime numbers less than a non-negative number, n.
	 */
	
	// Remember 1 is not prime.
	// O(n) time, O(n) space
	public int countPrimes(int n) {
		if (n == 0 || n == 1) return 0;
		// less than n
		boolean[] flags = new boolean[n];
		init(flags);
		
		int prime = 2;
		double limit = Math.sqrt(n);
		while (prime <= limit) {
			crossOff(flags, prime);
			prime = getNextPrime(flags, prime);
		}
		int count = 0;
		for (boolean x : flags) {
			if (x) count++;
		}
		return count;
	}
	
	private int getNextPrime(boolean[] flags, int prime) {
		for (int i = prime + 1; i < flags.length; i++) {
			if (flags[i]) return i;
		}
		return 0;
	}

	private void crossOff(boolean[] flags, int prime) {
		// Look at the i initialization(*) and step(+)
		for (int i = prime * prime; i < flags.length; i += prime)
			flags[i] = true;
	}

	private void init(boolean[] flags) {
		for (int i = 2; i < flags.length; i++) flags[i] = true;
	}
}
