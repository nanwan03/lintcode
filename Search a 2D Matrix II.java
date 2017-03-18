public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int rIndex = 0;
        int cIndex = col - 1;
        int count = 0;
        while (rIndex < row && cIndex >= 0) {
            int temp = matrix[rIndex][cIndex];
            if (temp == target) {
                count++;
                rIndex++;
                cIndex--;
            } else if (temp < target) {
                rIndex++;
            }  else {
                cIndex--;
            }
        }
        return count;
    }
}
