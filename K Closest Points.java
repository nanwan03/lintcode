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
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public Point globalOrigin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        globalOrigin = origin;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                int diff = getDistance(b, globalOrigin) - getDistance(a, globalOrigin);
                if(diff == 0) {
                    diff = b.x - a.x;
                }
                if (diff == 0) {
                    diff = b.y - a.y;
                }
                return diff;
            }
        });
        
        for (Point pt : points) {
            pq.add(pt);
            if (pq.size() > k)
                pq.poll();
        }
        
        
        Point[] result = new Point[k];
        while (k - 1 >= 0) {
            result[--k] = pq.poll();
        }
        
        return result;
    }
    public int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y); 
    }
}