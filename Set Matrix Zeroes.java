public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean emptyRow = false;
        boolean emptyCol = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                emptyRow = true;
            }
        }
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                emptyCol = true;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (emptyRow) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if (emptyCol) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
