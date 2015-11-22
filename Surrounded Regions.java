public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    private class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void surroundedRegions(char[][] board) {
        // Write your code here
         if (board == null || board.length == 0) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new Node(i, 0));
            }
            if (board[i][col - 1] == 'O') {
                queue.offer(new Node(i, col - 1));
            }
        }
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new Node(0, j));
            }
            if (board[row - 1][j] == 'O') {
                queue.offer(new Node(row - 1, j));
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nx = node.x;
            int ny = node.y;
            board[nx][ny] = 'Y';
            if (nx >= 1 && board[nx - 1][ny] == 'O') {
                queue.offer(new Node(nx - 1, ny));
            }
            if (nx < row - 1 && board[nx + 1][ny] == 'O') {
                queue.offer(new Node(nx + 1, ny));
            }
            if (ny >= 1 && board[nx][ny - 1] == 'O') {
                queue.offer(new Node(nx, ny - 1));
            }
            if (ny < col - 1 && board[nx][ny + 1] == 'O') {
                queue.offer(new Node(nx, ny + 1));
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
