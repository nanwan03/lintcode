/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
        int rst = 0;
        for (int i = 1; i < n; ++i) {
            if (knows(rst, i)) {
                rst = i;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (rst != i) {
                if (knows(rst, i) || !knows(i, rst)) {
                    return -1;
                }
            }
        }
        return rst;
    }
}