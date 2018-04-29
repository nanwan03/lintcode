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
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        Collections.sort(intervals, (a, b)->(a.start == b.start ? a.end - b.end : a.start - b.start));
        Queue<Interval> heap = new PriorityQueue<Interval>((a, b)->(a.end == b.end ? a.start - b.start : a.end - b.end));
        int rst = 0;
        for (Interval i : intervals) {
            while (!heap.isEmpty() && heap.peek().end <= i.start) {
                heap.poll();
            }
            heap.offer(i);
            rst = Math.max(rst, heap.size());
        }
        return rst;
    }
}