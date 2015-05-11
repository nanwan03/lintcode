/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge wether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n == 0) {
            return 0;
        }
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (VersionControl.isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return VersionControl.isBadVersion(left) ? left : right;
    }
}

