/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
     private class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> rst = new ArrayList<Interval>();
    	if (intervals == null || intervals.size() == 0) {
    		return rst;
    	}
    	Collections.sort(intervals, new IntervalComparator());
    	Interval last = intervals.get(0);
    	for (int i = 1; i < intervals.size(); i++) {
    		Interval cur = intervals.get(i);
    		if (last.end >= cur.start) {
    			last.end = Math.max(last.end, cur.end);
    		} else {
    			rst.add(last);
    			last = cur;
    		}
    	}
    	rst.add(last);
    	return rst;
    }

}
