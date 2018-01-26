// How to run my code :

/*
the following code is written in main function 

NumberOfIslands obj = new NumberOfIslands();
char[][] grid = {{'1', '0'}, {'0', '1'}};
System.out.println(obj.numOfIslands(grid));

Explanation.
1- make an object from my class
=> NumberOfIslands obj = new NumberOfIslands();

2- initalize a grid array 
=> char[][] grid = {{'1', '0'}, {'0', '1'}};

3- call the function numOfIslands or numOfIslandsI and give it the grid array as param
=> obj.numOfIslands(grid); which returns the number of islands

*/

public class NumberOfIslands {

	// Time complexity O(M* N) and space complexity is O(M * N), where N*M is the
	// size of the grid.
	public int numOfIslands(char[][] grid) {
		int count = 0;
		// Check validity.
		if (grid == null || grid.length < 1) return count;
		// Extra space.
		boolean visited[][] = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// There is an island?
				if (grid[i][j] == '1' && !visited[i][j]) {
					// Explore the island.
					dfs(grid, visited, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
		// check the range
		if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1'
				&& !visited[row][col]) {
			visited[row][col] = true;
			// Check neighbors (horizontally or vertically).
			dfs(grid, visited, row - 1, col);
			dfs(grid, visited, row + 1, col);
			dfs(grid, visited, row, col - 1);
			dfs(grid, visited, row, col + 1);
		}
	}

	// we can solve the problem without using the extra space (Visited array),
	// by changing the grid array itself, but this is not recommended.
	public int numOfIslandsI(char[][] grid) {
		int count = 0;
		// Check validity.
		if (grid == null || grid.length < 1) return count;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// There is an land?
				if (grid[i][j] == '1') {
					// Explore the island.
					dfsI(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void dfsI(char[][] grid, int row, int col) {
		// check the range
		if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
			grid[row][col] = '0';
			// Check neighbors (horizontally or vertically).
			dfsI(grid, row - 1, col);
			dfsI(grid, row + 1, col);
			dfsI(grid, row, col - 1);
			dfsI(grid, row, col + 1);
		}
	}
}

