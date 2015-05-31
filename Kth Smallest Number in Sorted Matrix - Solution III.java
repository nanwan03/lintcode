public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     * MLE
     */
	class Pair<F, S> {
	    private F first; //first member of pair
	    private S second; //second member of pair

	    public Pair(F first, S second) {
	        this.first = first;
	        this.second = second;
	    }

	    public void setFirst(F first) {
	        this.first = first;
	    }

	    public void setSecond(S second) {
	        this.second = second;
	    }

	    public F getFirst() {
	        return first;
	    }

	    public S getSecond() {
	        return second;
	    }
	}
    private void addElement(TreeMap<Integer, List<Pair<Integer, Integer>>> heap, int value, int x, int y) {
    	if (!heap.containsKey(value)) {
    		heap.put(value, new ArrayList<Pair<Integer, Integer>>());
    	}
    	heap.get(value).add(new Pair(x, y));
    }
    private Pair<Integer, Integer> getFirst(TreeMap<Integer, List<Pair<Integer, Integer>>> heap) {
    	int value = heap.firstKey();
    	int x = heap.get(value).get(0).first;
    	int y = heap.get(value).get(0).second;
    	heap.get(value).remove(0);
    	if (heap.get(value).size() == 0) {
    		heap.remove(value);
    	}
    	return new Pair(x, y);
    }
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix.length < matrix[0].length) {
            return hSearch(matrix, k);
        } else {
            return vSearch(matrix, k);
        }
    }
    private int hSearch(int[][] matrix, int k) {
    	TreeMap<Integer, List<Pair<Integer, Integer>>> heap = new TreeMap<Integer, List<Pair<Integer, Integer>>>();
        for (int i = 0; i < Math.min(matrix.length, k); ++i) {
        	addElement(heap, matrix[i][0], i, 0);
        }
        int rst = matrix[0][0];
        while (!heap.isEmpty() && k-- != 0) {
        	rst = heap.firstKey();
            Pair<Integer, Integer> n = getFirst(heap);
            int x = n.getFirst();
            int y = n.getSecond();
            if (y + 1 < matrix[0].length) {
                addElement(heap, matrix[x][y + 1], x, y + 1);
            }
            
        }
        return rst;
    }
    private int vSearch(int[][] matrix, int k) {
    	TreeMap<Integer, List<Pair<Integer, Integer>>> heap = new TreeMap<Integer, List<Pair<Integer, Integer>>>();
        for (int i = 0; i < Math.min(matrix[0].length, k); ++i) {
            addElement(heap, matrix[0][i], 0, i);
        }
        int rst = matrix[0][0];
        while (!heap.isEmpty() && k-- != 0) {
            rst = heap.firstKey();
            Pair<Integer, Integer> n = getFirst(heap);
            int x = n.getFirst();
            int y = n.getSecond();
            if (x + 1 < matrix.length) {
                addElement(heap, matrix[x + 1][y], x + 1, y);
            }
        }
        return rst;
    }
}