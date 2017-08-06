public class Solution {
    /**
     * @param stones a list of stones' positions in sorted ascending order
     * @return true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        // Write your code here
        if (stones.length <= 1) {
        	return true;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < stones.length; i++) {
            if (i > 3 && stones[i] > stones[i - 1] * 2) {
                return false;
            }
        	map.put(stones[i], new HashSet<Integer>() );
        }
        map.get(0).add(1);
        
        for (int i = 0; i < stones.length - 1; i++) {
        	int stone = stones[i];
        	for (int step : map.get(stone)) {
        		int reach = step + stone;
        		if (reach == stones[stones.length - 1]) {
        			return true;
        		}
        		if (map.containsKey(reach)) {
            		Set<Integer> set = map.get(reach);
            		set.add(step);
            		if (step - 1 > 0) {
            		    set.add(step - 1);
            		}
            		set.add(step + 1);
        		}
        	}
        }
        return false;
    }
}