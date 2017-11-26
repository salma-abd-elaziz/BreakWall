package leetcode;

public class ClimbingStairs {

	/*
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 */
	/*
	 * the idea is like the fibonacii, where the n steps is ths sum of the
	 * previous two no of steps to go up n-1 and n-2
	 */

	public int climbStairs(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int fi = 1;
		int fii = 2;
		int fn = 0;

		for (int i = 2; i < n; i++) {
			fn = fi + fii;
			fi = fii;
			fii = fn;
		}
		return fn;
	}

}
