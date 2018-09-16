package leetcode.arrays;

public class GameofLife {
	 /* According to the Wikipedia's article:
	 * "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
	 * 
	 * Given a board with m by n cells, each cell has an initial state live (1)
	 * or dead (0). Each cell interacts with its eight neighbors (horizontal,
	 * vertical, diagonal) using the following four rules (taken from the above
	 * Wikipedia article):
	 * 
	 * Any live cell with fewer than two live neighbors dies, as if caused by
	 * under-population. Any live cell with two or three live neighbors lives on
	 * to the next generation. Any live cell with more than three live neighbors
	 * dies, as if by over-population.. Any dead cell with exactly three live
	 * neighbors becomes a live cell, as if by reproduction. Write a function to
	 * compute the next state (after one update) of the board given its current
	 * state. The next state is created by applying the above rules
	 * simultaneously to every cell in the current state, where births and
	 * deaths occur simultaneously.
	 */
	private static final int LIVE = 1;
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int[][] res = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveNighbors = getNumofLiveNeighbors(i, j, board);
                if (board[i][j] == LIVE) {
                    res[i][j] = liveNighbors == 2 || liveNighbors == 3 ? 1 : 0;
                } else {
                    res[i][j] = liveNighbors == 3 ? 1 : 0;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = res[i][j];
            }
        }   
    }
    
    private int getNumofLiveNeighbors (int i, int j, int[][] board) {
        int count = 0;
        // Right.
        if (j + 1 < board[0].length && board[i][j + 1] == 1) count++;
        // Left.
        if (j - 1 >= 0 && board[i][j - 1] == 1) count++;
        // Top.
        if (i - 1 >= 0 && board[i - 1][j] == 1) count++;
        // Down.
        try {
            if (i + 1 < board.length && board[i + 1][j] == 1) count++;
        } catch (Exception e) {
            System.out.println(i);   
        }
        // Top right.
        if (i - 1 >= 0 && j + 1 < board[0].length && board[i - 1][j + 1] == 1) count++;
        // Top left.
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) count++;
        // Down right.
         if (i + 1 < board.length && j + 1 < board[0].length && board[i + 1][j + 1] == 1) count++;
        // Down left.
         if (i + 1 < board.length && j - 1 >= 0 && board[i + 1][j - 1] == 1) count++;
        return count;
    }
}
