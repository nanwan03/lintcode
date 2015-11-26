public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Write your code here
        List<Integer> rst = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return rst;
        }
        int[][] shift = new int[4][2];
        shift[0] = new int[]{0, 1};
        shift[1] = new int[]{1, 0};
        shift[2] = new int[]{0, -1};
        shift[3] = new int[]{-1, 0};
        int x = 0;
        int y = 0;
        int dir = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row * col; i++) {
            rst.add(matrix[x][y]);
            matrix[x][y] = 0;
            int nx = x + shift[dir][0];
            int ny = y + shift[dir][1];
            if (nx < 0 || nx >= row || ny < 0 || ny >= col || matrix[nx][ny] == 0) {
                dir = (dir + 1) & 3;
                nx = x + shift[dir][0];
                ny = y + shift[dir][1];
            }
            x = nx;
            y = ny;
        }
        return rst;
    }
}
