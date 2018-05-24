public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;  
        boolean[][] mark = new boolean[row][col];  
        Set<String> s = new HashSet<String>();  
          
        for (int i = 0; i < row; ++i) {  
            for (int j = 0; j < col; ++j) {  
                if (!mark[i][j] && grid[i][j] == 1) {  
                    int miny = j;  
                    Queue<int[]> queue = new LinkedList<int[]>();  
                    queue.add(new int[]{i, j});  
                    mark[i][j] = true;  
                    grid[i][j] = 0;  
                    
                    while (!queue.isEmpty()) {  
                        int[] t = queue.remove();  
                        int x = t[0];
                        int y = t[1];  
                        for (int[] dir : dirs) {  
                            int nx = x + dir[0];
                            int ny = y + dir[1];  
                            if (nx < 0 || nx >= row ||ny <0 || ny >= col) {
                                continue;  
                            }
                            if (mark[nx][ny] || grid[nx][ny] == 0) {
                                continue;  
                            }
                            queue.add(new int[]{nx, ny});  
                            mark[nx][ny] = true;  
                            grid[nx][ny] = 0;  
                            miny = Math.min(miny, ny);  
                        }  
                    }  
                      
                    for (int ii = 0; ii < row; ++ii)  {
                        for (int jj = 0; jj < col; ++jj) {   
                            if (mark[ii][jj]) {  
                                mark[ii][jj] = false;  
                                mark[ii - i][jj - miny] = true;  
                            }  
                        }
                    }
                     
                    StringBuilder sb  = new StringBuilder();  
                    for(int ii = 0; ii < row; ++ii)  
                        for(int jj = 0; jj < col; ++jj) {  
                            if (mark[ii][jj]) {  
                                mark[ii][jj] = false;  
                                sb.append(1);  
                            } else {  
                                sb.append(0);  
                            }  
                        }  
                    s.add(sb.toString());  
                }  
            }  
        }
        return s.size();  
    }
}