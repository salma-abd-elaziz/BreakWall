package leetcode.arrays;

public class Searcha2DMatrixII {

	/*
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted in ascending from left to right. Integers
	 * in each column are sorted in ascending from top to bottom.
	 */
	
	// O(N^2) and O(1) apace
	public boolean searchMatrix(int[][] matrix, int target) {
        // starting from top right 
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (target > matrix[i][j]) {
                i++; // Go down (bigger elements are down)
            } else if (target < matrix[i][j]) {
                j--; // Go left (smaller elements are left) 
            } else {
                return true;
            }
        }
        return false;
    }
	
	
    public boolean searchMatrixI(int[][] matrix, int target) {
        // starting from down left 
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target > matrix[i][j]) {
                j++; // Go right (bigger elements are to the right)
            } else if (target < matrix[i][j]) {
                i--;// Go up (smaller elements are up) 
            } else {
                return true;
            }
        }
        return false;
    }
}
