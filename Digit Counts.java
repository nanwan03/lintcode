class Solution {
    //param k : description of k
    //param n : description of n
    //return ans a integer
    public int digitCounts(int k, int n) {
        int rst = 0;
        for (int i = 0; i <= n; i++) {
            rst += num(k, ""+i);
        }
        return rst;
    }
    private int num(int k, String str) {
        int rst = 0;
        for (char c : str.toCharArray()) {
            if (c - '0' == k) {
                rst++;
            }
        }
        return rst;
    }
};

