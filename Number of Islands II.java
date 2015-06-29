/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
    	List<Integer> rst = new ArrayList<Integer>();
    	if (operators == null || operators.length == 0) {
    		return rst;
    	}
    	int[][] root = new int[n][m];
    	for (int i = 0; i < n; ++i) {
    		for (int j = 0; j < m; ++j) {
    			root[i][j] = -1;
    		}
    	}
    	int lands = 0;
    	for (Point p : operators) {
    		root[p.x][p.y] = (p.x * m) + p.y;
    		lands++;
    		lands = unionNeighbor(root, p.x, p.y, lands);
    		rst.add(lands);
    	}
    	return rst;
    }
    private static int unionNeighbor(int[][] root, int x, int y, int lands) {
    	if (x - 1 >= 0 && root[x - 1][y] != -1) {
    		lands = union(root, x, y, x - 1, y, lands);
    	}
    	if (x + 1 < root.length && root[x + 1][y] != -1) {
    		lands = union(root, x, y, x + 1, y, lands);
    	}
    	if (y - 1 >= 0 && root[x][y - 1] != -1) {
    		lands = union(root, x, y, x, y - 1, lands);
    	}
    	if (y + 1 < root[0].length && root[x][y + 1] != -1) {
    		lands = union(root, x, y, x, y + 1, lands);
    	}
    	return lands;
    }
    private static int union(int[][] root, int x, int y, int u, int v, int lands) {
    	int xyRoot = find(root, x, y);
    	int uvRoot = find(root, u, v);
    	if (xyRoot != uvRoot) {
    		int temp = Math.max(xyRoot, uvRoot);
    		root[temp / root[0].length][temp % root[0].length] = Math.min(xyRoot, uvRoot);
    		lands--;
    	}
    	return lands;
    }
    private static int find(int[][] root, int x, int y) {
    	if (root[x][y] != -1 && root[x][y] != (x * root[0].length) + y) {
    		root[x][y] = find(root, root[x][y] / root[0].length, root[x][y] % root[0].length);
    	}
    	return root[x][y];
    }
}
