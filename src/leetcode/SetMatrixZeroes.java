package leetcode;

public class SetMatrixZeroes {

	/*
	 * Given a m x n matrix, if an element is 0, set its entire row and column
	 * to 0. Do it in place.
	 */
	
	// O(n * m) where n is the number of raws and m is number of columns.
	public void setZeroes(int[][] matrix) {
        // Will use the first row and first column as our buffer.
        boolean firstRaw = false, firstCol = false;
        // check if the first raw and col will need to set to zerso.
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRaw = true; 
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true; 
                break;
            }
        }
        
        // Check the rest of the array.
        for (int i =1 ; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Set the array to zerso.
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                setColtoZero(i, matrix);
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                setRawtoZero(i, matrix);
            }
        }
        if (firstCol) setColtoZero(0, matrix);
        if (firstRaw) setRawtoZero(0, matrix);
    }
    
    private void setRawtoZero(int raw, int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[raw][i] = 0;
        }
    }
    private void setColtoZero(int col, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
