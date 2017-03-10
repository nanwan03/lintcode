public class Solution {
    private class heightComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        }
    }
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (buildings == null || buildings.length == 0) {
            return rst;
        }
        List<int[]> skyline = getSkyline(buildings);
        return convert(skyline);
    }
    private List<int[]> getSkyline(int[][] buildings) {
        List<int[]> rst = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0) {
            return rst;
        }
        List<int[]> height = new ArrayList<int[]>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, new heightComparator());
        Queue<Integer> heap = new PriorityQueue<Integer>(buildings.length, Collections.reverseOrder());
        heap.offer(0);
        int prevHeight = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                heap.offer(-h[1]);
            } else {
                heap.remove(h[1]);
            }
            int curHeight = heap.peek();
            if (prevHeight != curHeight) {
                rst.add(new int[]{h[0], curHeight});
                prevHeight = curHeight;
            }
        }
        return rst;
    }
    private ArrayList<ArrayList<Integer>> convert(List<int[]> skyline) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	if (skyline == null || skyline.size() <= 1) {
    		return rst;
    	}
    	for (int i = 0; i < skyline.size() - 1; ++i) {
    		if (skyline.get(i)[1] == 0) {
    			continue;
    		}
    		ArrayList<Integer> tmp = new ArrayList<Integer>();
    		int[] curPoint = skyline.get(i);
    		int[] nextPoint = skyline.get(i + 1);
    		tmp.add(curPoint[0]);
    		tmp.add(nextPoint[0]);
    		tmp.add(curPoint[1]);
    		rst.add(tmp);
    	}
    	return rst;
    }
}