public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        if (A == null || A.length == 0) {
        	return 0;
        }
        long rst = 1;
        int position = 2;
        long factor = 1;
        Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        numbers.put(A[A.length - 1], 1);
        for (int i = A.length - 2; i >= 0; --i) {
        	Map<Integer, Integer> successor = new HashMap<Integer, Integer>();
        	if (numbers.containsKey(A[i])) {
        		numbers.put(A[i], numbers.get(A[i]) + 1);
        	} else {
        		numbers.put(A[i], 1);
        	}
        	for (int j = i + 1; j < A.length; ++j) {
        		if (A[i] > A[j]) {
        			if (successor.containsKey(A[j])) {
        				successor.put(A[j], successor.get(A[j]) + 1);
        			} else {
        				successor.put(A[j], 1);
        			}
        		}
        	}
        	Iterator<Map.Entry<Integer, Integer>> it = successor.entrySet().iterator();
        	while (it.hasNext()) {
        		Map.Entry<Integer, Integer> entry = it.next();
        		rst += factor * entry.getValue() / numbers.get(A[i]);
        	}
        	factor = factor * position / numbers.get(A[i]);
        	++position;
        }
        return rst;
    }
}
