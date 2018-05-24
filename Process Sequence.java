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
     * @param logs: Sequence of processes
     * @param queries: Sequence of queries
     * @return: Return the number of processes
     */
    public List<Integer> numberOfProcesses(List<Interval> logs, List<Integer> queries) {
        // Write your code here
        List<Integer> rst = new ArrayList<Integer>();
        List<Integer> tmp = new ArrayList<Integer>();
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (Interval i: logs) {
            tmp.add(i.start);
            tmp.add(i.end);
            tmp.add(i.end + 1);
        }
        for (int i: queries) {
            tmp.add(i);
        }
        Collections.sort(tmp);
        int index = 1;
        for (int i: tmp) {
            if (!hash.containsKey(i)) {
                hash.put(i, index);
                index++;
            }
        }
        int [] count = new int[index + 1];
        for(Interval i: logs) {
            count[hash.get(i.start)]++;
            count[hash.get(i.end + 1)]--;
        }
        for(int i = 1; i <= index; i++) {
            count[i] += count[i - 1];
        }
        for(int i: queries) {
            rst.add(count[hash.get(i)]);
        }
        return rst;
    }
}