public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; ++i) {
            if (board[i][0] == 'O') {
                mark(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                mark(board, i, col - 1);
            }
        }
        for (int j = 0; j < col; ++j) {
            if (board[0][j] == 'O') {
                mark(board, 0, j);
            }
            if (board[row - 1][j] == 'O') {
                mark(board, row - 1, j);
            }
        }
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void mark(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'Y';
        mark(board, i - 1, j);
        mark(board, i + 1, j);
        mark(board, i, j - 1);
        mark(board, i, j + 1);
    }
}