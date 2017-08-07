public class Solution {
    /**
     * @param envelopes a number of envelopes with widths and heights
     * @return the maximum number of envelopes
     */
    private class Cmp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        // Write your code here
        Arrays.sort(envelopes, new Cmp());
        int rst = 0;
        int dp[] = new int[envelopes.length];
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, rst, envelope[1]);
            if(index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if(index == rst) {
                rst++;
            }
        }
        return rst;
    }
}