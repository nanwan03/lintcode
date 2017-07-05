public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rst = new int[row * col];
        int index = 0;
        boolean flag = true;
        for (int sum = 0; sum < row + col - 1; ++sum) {
            if (flag) {
                for (int i = Math.min(sum, row - 1); i >= Math.max(0, sum - col + 1); --i) {
                    int j = sum - i;
                    rst[index++] = matrix[i][j];
                }
            } else {
                for (int i = Math.max(0, sum - col + 1); i <= Math.min(sum, row - 1); ++i) {
                    int j = sum - i;
                    rst[index++] = matrix[i][j];
                }
            }
            flag ^= true;
        }
        return rst;
    }
}s