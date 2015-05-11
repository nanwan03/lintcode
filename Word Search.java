public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean flag = helper(board, i, j, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int rowStart, int colStart, String s, int pos) {
        if (pos == s.length()) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        if (rowStart < 0 || rowStart >= row || colStart < 0 || colStart >= col || s.charAt(pos) != board[rowStart][colStart]) {
            return false;
        }
        board[rowStart][colStart] = '.';
        boolean flag = helper(board, rowStart - 1, colStart, s, pos + 1) ||
                        helper(board, rowStart + 1, colStart, s, pos + 1) ||
                        helper(board, rowStart, colStart - 1, s, pos + 1) ||
                        helper(board, rowStart, colStart + 1, s, pos + 1);
        board[rowStart][colStart] = s.charAt(pos);
        return flag;
    }
}
