import java.util.Map.*;

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        if (nums == null || nums.size() == 0) {
        	return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i: nums) {
        	if (map.containsKey(i)) {
        		map.put(i, map.get(i) + 1);
        	} else if (map.size() < k) {
        		map.put(i, 1);
        	} else {
        		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
        		while (it.hasNext()) {
        			Entry<Integer, Integer> entry = it.next();
        			if (entry.getValue() == 1) {
        				it.remove();
        			} else {
        				entry.setValue(entry.getValue() - 1);
        			}
        		}
        	}
        }
        int count = 0;
        int rst = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
        	if (entry.getValue() > count) {
        		count = entry.getValue();
        		rst = entry.getKey();
        	}
        }
        return rst;
    }
}

