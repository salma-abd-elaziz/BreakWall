package leetcode.dp;

public class UniquePathsII {

	/*
	 * Follow up for "Unique Paths":
	 * 
	 * Now consider if some obstacles are added to the grids. How many unique
	 * paths would there be?
	 * 
	 * An obstacle and empty space is marked as 1 and 0 respectively in the
	 * grid.
	 * 
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[] dp = new int[obstacleGrid[0].length];

		dp[0] = 1;
		for (int i = 0; i < obstacleGrid.length; i++) {
			// Start j from 0 as the first column may change.
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1)
					dp[j] = 0;
				else if (j > 0)
					dp[j] += dp[j - 1];
			}
		}
		return dp[obstacleGrid[0].length - 1];
	}
}
