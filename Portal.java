public class Solution {
    /**
     * @param Maze: 
     * @return: nothing
     */
    private static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int Portal(char[][] Maze) {
        if (Maze == null || Maze.length == 0) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        int row = Maze.length;
        int col = Maze[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (Maze[i][j] == 'S') {
                    queue.offer(new Node(i, j));
                    Maze[i][j] = '-';
                }
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node node = queue.poll();
                if (Maze[node.x][node.y] == 'E') {
                    return step;
                }
                List<Node> neighbors = getNeighbors(Maze, node.x, node.y, row, col);
                for (Node neighbor : neighbors) {
                    queue.offer(neighbor);
                }
            }
            step++;
        }
        return -1;
    }
    private List<Node> getNeighbors(char[][] Maze, int x, int y, int row, int col) {
        List<Node> rst = new ArrayList<Node>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                continue;
            }
            if (Maze[nx][ny] == '*' || Maze[nx][ny] == 'E') {
                rst.add(new Node(nx, ny));
                if (Maze[nx][ny] == '*') {
                    Maze[nx][ny] = '-';
                }
            }
        }
        return rst;
    }
}