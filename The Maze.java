public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int m = maze.length, n = maze[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> que = new LinkedList<>();
        
        que.offer(start[0] * n + start[1]);
        visited[start[0]][start[1]] = true;
        
        int[] dirs = {-1, 0, 1, 0, -1};
        
        while (!que.isEmpty()) {
            int cur = que.poll();
            
            for (int k = 0; k < 4; ++k) {
                int x = cur / n, y = cur % n;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                        x += dirs[k];
                        y += dirs[k + 1];
                }
                x -= dirs[k];
                y -= dirs[k + 1];
                
                if (x == destination[0] && y == destination[1]) {
                    return true;
                }
                
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    que.offer(x * n + y);
                }
            }
        }
        
        return false;
    }
}