public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return 0;
        }
        int temp = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            temp += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (temp < 0) {
                temp = 0;
                start = i + 1;
            }
        }
        return sum < 0 ? -1 : start;
    }
}
