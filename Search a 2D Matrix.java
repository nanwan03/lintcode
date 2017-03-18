public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int digit = matrix[mid / cols][mid % cols];
            if (digit == target) {
                return true;
            } else if (digit < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start / cols][start % cols] == target) {
            return true;
        }
        if (matrix[end / cols][end % cols] == target) {
            return true;
        }
        return false;
    }
}
