import java.util.ArrayList;

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        // write your code
        if (matrix == null || matrix.size() == 0) {
            return false;
        }
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int start = 0;
        int end = rows * cols - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int digit = matrix.get(mid / cols).get(mid % cols);
            if (digit == target) {
                return true;
            } else if (digit < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix.get(start / cols).get(start % cols) == target) {
            return true;
        }
        if (matrix.get(end / cols).get(end % cols) == target) {
            return true;
        }
        return false;
    }
}

