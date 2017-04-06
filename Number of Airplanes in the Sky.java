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
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        }
    }
    private class IntervalEndComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        Collections.sort(airplanes, new IntervalComparator());
        Queue<Interval> heap = new PriorityQueue<Interval>(airplanes.size(), new IntervalEndComparator());
        int rst = 0;
        for (Interval interval : airplanes) {
            while (!heap.isEmpty() && heap.peek().end <= interval.start) {
                heap.poll();
            }
            heap.offer(interval);
            rst = Math.max(rst, heap.size());
        }
        return rst;
    }
}