package leetcode;

public class MultiplyTwoIntegers {

	
	public int mainmutiply(int n, int k) {
		if (n == 0 || k == 0) return 0;
		// if n is negative the algorithm will add -n + -n ... 
		// so the result will be correct.
		return  multiply(n, k);
	}

	public int multiply(int n, int k) {
		if (k == 0) return 0;
		if (k > 0) return n + multiply(n, k - 1);
		return -multiply(n, -k);
	}
}
