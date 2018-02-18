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
    /**
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
    private static final int M = 1000001;
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        // Write your code here
        int[] visit = new int[M];
        for(int i = 0; i < M; i++) {
            visit[i] = 0;
        }
        for(int i = 0; i < seqA.size(); i++) {
            for(int j = seqA.get(i).start; j <= seqA.get(i).end; j++) {
                visit[j]++;
            }
        }
        for(int i = 0; i < seqB.size(); i++) {
            for(int j = seqB.get(i).start; j <= seqB.get(i).end; j++) {
                visit[j] ++;
            }
        }
        List<Interval> rst = new ArrayList<Interval>();
        for(int i = 0; i < M; i++) {
            if(visit[i] >= 2) {
                int start = i;
                while (i + 1 < M && visit[i + 1] >= 2) {
                    i++;
                }
                rst.add(new Interval(start, i));
            }
        }
        return rst;
    }
}