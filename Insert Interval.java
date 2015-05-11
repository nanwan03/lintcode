import java.util.ArrayList;
import lintcode.util.Interval;


/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> rst = new ArrayList<Interval>();
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        int insertPos = 0;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                rst.add(interval);
                insertPos++;
            } else if (newInterval.end < interval.start) {
                rst.add(interval);
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        rst.add(insertPos, newInterval);
        return rst;
    }
}
