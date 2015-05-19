public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length == 0) {
            return 0;
        }
        Arrays.sort(S);
        int rst = 0;
        for (int k = S.length - 1; k > 1; --k) {
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (S[i] + S[j] <= S[k]) {
                    i++;
                } else {
                    rst += j - i;
                    j--;
                }
            }
        }
        return rst;
    }
}

