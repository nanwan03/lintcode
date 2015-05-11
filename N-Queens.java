import java.util.ArrayList;

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> rst = new ArrayList<ArrayList<String>>();
        if (n == 0) {
            return rst;
        }
        ArrayList<Integer> cols = new ArrayList<Integer>();
        search(n, cols, rst);
        return rst;
    }
    private void search(int n, ArrayList<Integer> cols, ArrayList<ArrayList<String>> rst) {
        if (n == cols.size()) {
            rst.add(drawBoard(cols));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isValid(cols, i)) {
                cols.add(i);
                search(n, cols, rst);
                cols.remove(cols.size() - 1);
            }
        }
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
    private ArrayList<String> drawBoard(ArrayList<Integer> cols) {
        ArrayList<String> board = new ArrayList<String>();
        for (int i = 0; i < cols.size(); i++) {
            String rst = "";
            for (int j = 0; j < cols.size(); j++) {
                if (j == cols.get(i)) {
                    rst += "Q";
                } else {
                    rst += ".";
                }
            }
            board.add(rst);
        }
        return board;
    }
};
