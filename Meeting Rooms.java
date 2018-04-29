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
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.size() == 0) {
            return true;
        }
        Collections.sort(intervals, (a, b)->(a.start == b.start ? a.end - b.end : a.start - b.start));
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); ++i) {
            Interval cur = intervals.get(i);
            if (prev.end <= cur.start) {
                prev = cur;
            } else {
                return false;
            }
        }
        return true;
    }
}