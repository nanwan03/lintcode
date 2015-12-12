public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        if (n == 1) {
            return true;
        } else if (n == 0) {
            return false;
        }
        Set<Long> set = new HashSet<Long>();
        set.add((long)n);
        return isHappy(set, n);
    }
    private boolean isHappy(Set<Long> set, long cur) {
        if (cur == 1L) {
            return true;
        } else {
            long next = getNext(cur);
            if (!set.add(next)) {
                return false;
            }
            return isHappy(set, next);
        }
    }
    private long getNext(long cur) {
        long next = 0;
        while (cur != 0) {
            long rst = cur % 10;
            next = next + rst * rst;
            cur /= 10;
        }
        return next;
    }
}