class Pos {
	int x;
	int y;
	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    private static boolean[][] rowFlags = new boolean[9][10];
	private static boolean[][] colFlags = new boolean[9][10];
	private static boolean[][] blockFlags = new boolean[9][10];
    public boolean isValidSudoku(char[][] board) {
        init();
    	for (int i = 0; i < 9; ++i) {
    		for (int j = 0; j < 9; ++j) {
    			if (board[i][j] != '.') {
    			    if (isValid(i, j, board[i][j] - '0')) {
    			        setAllFlags(i, j, board[i][j] - '0', true);
    			    } else {
    			        return false;
    			    }
    			}
    		}
    	}
        return true;
    }
    private static void init() {
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 10; ++j) {
				rowFlags[i][j] = false;
				colFlags[i][j] = false;
				blockFlags[i][j] = false;
			}
		}
	}
    private static int getBlockNum(int row, int col) {
		return (row / 3) * 3 + (col / 3);
	}
	private static void setAllFlags(int row, int col, int number, boolean flag) {
		rowFlags[row][number] = flag;
		colFlags[col][number] = flag;
		blockFlags[getBlockNum(row, col)][number] = flag;
	}
	private static boolean isValid(int row, int col, int number) {
		return !rowFlags[row][number] && !colFlags[col][number] && !blockFlags[getBlockNum(row, col)][number];
	}
};
