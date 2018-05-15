public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    private static class Posn {
        int x;
        int y;
        int len;
        public Posn(int a, int b, int len){
            x = a;
            y = b;
            this.len = len;
        }
    }
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int m = maze.length;
        int n = maze[0].length;

        PriorityQueue<Posn> q = new PriorityQueue<Posn>((p1, p2)->(p1.len - p2.len));
        q.offer(new Posn(start[0], start[1], 0));
        boolean[][] visit = new boolean[m][n];

        while (!q.isEmpty()) {
            Posn cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            if (x == destination[0] && y == destination[1]) {
                return cur.len;
            }
            if (visit[x][y]) {
                continue;
            }
            visit[x][y] = true;
            for (int[] dir : dirs){
                int nx = x;
                int ny = y;
                int len = cur.len;
                while(nx >= 0 && nx < m  && ny >= 0 && ny < n && maze[nx][ny] == 0){
                    nx += dir[0];
                    ny += dir[1];
                    len++;
                }
                len--;
                nx -= dir[0];
                ny -= dir[1];
                q.offer(new Posn(nx, ny, len));
            }
        }
        return -1;
    }
}