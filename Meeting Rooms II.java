/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    private static class Node implements Comparable<Node> {
        public int val;
        public int flag;
        Node(int val, int flag) {
            this.val = val;
            this.flag = flag;
        }
        public int compareTo(Node a) {
            return this.val == a.val ? this.flag - a.flag : this.val - a.val;
        }
    }
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        List<Node> list = new ArrayList<Node>();
        for (Interval i : intervals) {
            list.add(new Node(i.start, 1));
            list.add(new Node(i.end, 0));
        }
        Collections.sort(list);
        int rst = 0;
        int temp = 0;
        for(Node n : list) {
            if (n.flag == 1) {
                temp++;
            } else {
                temp--;
            }
            rst = Math.max(rst, temp);
        }
        return rst;
    }
}