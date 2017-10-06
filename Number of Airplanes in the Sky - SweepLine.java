/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */


public class Solution {
    /*
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    private class Node implements Comparable<Node> {
        int value;
        int flag;
        Node(int value, int flag) {
            this.value = value;
            this.flag = flag;
        }
        public int compareTo(Node a) {
            return this.value == a.value ? this.flag - a.flag : this.value - a.value;
        }
    }
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        List<Node> list = new ArrayList<Node>();
        int count = 0;
        int rst = 0;
        for (Interval i : airplanes) {
            list.add(new Node(i.start, 1));
            list.add(new Node(i.end, 0));
        }
        Collections.sort(list);
        for (Node n : list) {
            if (n.flag == 1) {
                count++;
            } else {
                count--;
            }
            rst = Math.max(rst, count);
        }
        return rst;
    }
}