public class Solution {
    /*
     * @param x: An integer
     * @return: An integer
     */
    public int swapOddEvenBits(int x) {
        // write your code here
        return ( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) );
    }
}