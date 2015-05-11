public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
	public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int step = 0;
        int start = 0;
        int maxCover = 0;
        while (maxCover < A.length - 1) {
            step++;
            int max = 0;
            for (int i = start; i <= maxCover; i++) {
                max = Math.max(max, i + A[i]);
            }
            start = maxCover + 1;
            maxCover = Math.max(max, maxCover);
            if (maxCover >= A.length - 1) {
                return step;
            }
        }
        return step;
    }
}

