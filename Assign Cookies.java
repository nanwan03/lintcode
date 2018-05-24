public class Solution {
    /**
     * @param g: children's greed factor
     * @param s: cookie's size
     * @return: the maximum number
     */
    public int findContentChildren(int[] g, int[] s) {
        // Write your code here
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for (int i = 0; i < s.length; ++i) {
            if (index < g.length && g[index] <= s[i]) {
                index++;
            }
        }
        return index;
    }
}