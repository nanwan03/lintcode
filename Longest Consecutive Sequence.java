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
            if (map.get(i) == 0) {
                max = Math.max(max, mark(map, i));
            }
        }
        return max;
    }
    private int mark(Map<Integer, Integer> map, int i) {
        map.put(i, 1);
        int rst = 1;
        int temp = i;
        while (map.containsKey(temp + 1) && map.get(temp + 1) == 0) {
            temp++;
            rst++;
            map.put(temp, 1);
        }
        temp = i;
        while (map.containsKey(temp - 1) && map.get(temp - 1) == 0) {
            temp--;
            rst++;
            map.put(temp, 1);
        }
        return rst;
    }
}