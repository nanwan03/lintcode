import java.util.ArrayList;

class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        //write your code here
        ArrayList<Integer> cols = new ArrayList<Integer>();
        return search(n, cols, 0);
    }
    private int search(int n, ArrayList<Integer> col, int rst) {
        if (n ==col.size()) {
            return rst + 1;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(col, i)) {
                col.add(i);
                rst = search(n, col, rst);
                col.remove(col.size() - 1);
            }
        }
        return rst;
    }
    private boolean isValid(ArrayList<Integer> cols, int rowToPut) {
        int colSize = cols.size();
        for (int i = 0; i < colSize; i++) {
            if (rowToPut == cols.get(i)) {
                return false;
            }
            if (rowToPut + colSize == cols.get(i) + i) {
                return false;
            }
            if (rowToPut - colSize == cols.get(i) - i) {
                return false;
            }
        }
        return true;
    }
};


