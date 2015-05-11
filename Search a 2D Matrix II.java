public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        // write your code
        if (matrix == null || matrix.size() == 0) {
            return 0;
        }
        int row = matrix.size();
        int col = matrix.get(0).size();
        int rIndex = 0;
        int cIndex = col - 1;
        int count = 0;
        while (rIndex < row && cIndex >= 0) {
            int temp = matrix.get(rIndex).get(cIndex);
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

