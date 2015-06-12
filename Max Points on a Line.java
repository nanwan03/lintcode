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
     * @param points an array of point
     * @return an integer
     */
    private boolean isSame(Point a, Point b) {
		return a.x == b.x && a.y == b.y;
	}
    public int maxPoints(Point[] points) {
        // Write your code here
        if (points == null || points.length == 0) {
        	return 0;
        }
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int max = 0;
        for (int i = 0; i < points.length; i++) {
        	map.clear();
        	int dup = 1;
        	for (int j = i + 1; j < points.length; j++) {
        		if (isSame(points[i], points[j])) {
        			dup++;
        		}
        	}
        	for (int j = i + 1; j < points.length; j++) {
        		if (isSame(points[i], points[j])) {
        			continue;
        		}
        		double key = (points[j].x == points[i].x) ? Integer.MAX_VALUE : 0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
        		if (!map.containsKey(key)) {
        			map.put(key, dup + 1);
        		} else {
        			map.put(key, map.get(key) + 1);
        		}
        	}
        	if (map.values() == null || map.values().size() == 0) {
        		max = Math.max(max, dup);
        	} else {
        		for (int temp : map.values()) {
        			max = Math.max(max, temp);
        		}
        	}
        }
        return max;
    }
}
