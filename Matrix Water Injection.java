public class Solution {
    /**
     * @param matrix: the height matrix
     * @param R: the row of (R,C)
     * @param C: the columns of (R,C)
     * @return: Whether the water can flow outside
     */
    class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } 
    
    int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public String waterInjection(int[][] matrix, int R, int C) {
        // Write your code here
        int[][] vis = new int[matrix.length][matrix[0].length];
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(R, C));
        vis[R][C]=1;
        while(!q.isEmpty()) {
            Pair x = q.poll();
            if(x.x == 0 || x.x == matrix.length - 1 || x.y == 0 || x.y == matrix[0].length - 1) {
                return "YES";
            }
            int num = matrix[x.x][x.y];
            for(int i = 0; i < 4; i++) {
                int tx = x.x + dir[i][0];
                int ty = x.y + dir[i][1];
                if(tx < 0 || tx >= matrix.length || ty < 0 || ty >= matrix[0].length) {
                    continue;
                }
                if(matrix[tx][ty] < num && vis[tx][ty] == 0) {
                    q.offer(new Pair(tx,ty));
                    vis[tx][ty] = 1;
                }
            }
        }
        return "NO";
    }
}