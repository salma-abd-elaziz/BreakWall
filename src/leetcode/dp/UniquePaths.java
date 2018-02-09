package leetcode.dp;

public class UniquePaths {
	
	
	/*
		A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
		The robot can only move either down or right at any point in time. The robot is trying to reach 
		the bottom-right corner of the grid (marked 'Finish' in the diagram below).
		How many possible unique paths are there?
	*/

	/*
	 * The idea is to use dynamic programming, to find how many pathes exist to
	 * reach a specific slot, Inititially the 0 row and 0 column are all ones
	 * because there is olny one path to reach in slot in them because the robot
	 * is allowed only to move down or right, any slot can be reached by the no
	 * of pathes to reach the upper slot + the no of pathes to reach the left
	 * solt, so the number of pathes to reach the finish will be the the (m-1,
	 * n-1) slot
	 */

	/* O(MN) time, O(MN) space. */
	public int uniquePaths(int m, int n) {
		if (m == 1 || n == 1)
			return 1;

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 1;
				else {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
	 // O(mn) time, O(n) space.
	public int uniquePathes(int m, int n) {
		/*
		 * In the previous solution we generate the array row by row so we don't
		 * need to keep the all array
		 */
		
		if (n == 1 || m == 1) return 1;
		// One row 
		int[] dp = new int[n];
		dp[0] = 1; // First column always 1.
		for (int i = 0; i < m; i++) {
			// Start j from 1, because first column will not change.
			for (int j = 1; j < n; j++) {
				dp[j] += dp[j-1]; 
			}
		}
		return dp[n - 1];
	}

}
