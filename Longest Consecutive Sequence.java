import java.util.*;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if (num == null || num.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : num) {
            map.put(i, 0);
        }
        int max = 0;
        for (int i : num) {
            if (map.get(i) == 1) {
                continue;
            }
            int temp = i;
            int tempLength = 1;
            while (map.containsKey(temp + 1)) {
                temp++;
                tempLength++;
                map.put(temp, 1);
            }
            temp = i;
            while (map.containsKey(temp - 1)) {
                temp--;
                tempLength++;
                map.put(temp, 1);
            }
            max = Math.max(max, tempLength);
        }
        return max;
    }
}
