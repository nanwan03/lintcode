public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    private class heightComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        }
    }
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (buildings == null || buildings.length == 0) {
            return rst;
        }
        return getSkyline(buildings);
    }
    private ArrayList<ArrayList<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<int[]>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        Collections.sort(heights, new heightComparator());
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> heap = new PriorityQueue<Integer>(buildings.length, Collections.reverseOrder());
        heap.offer(0);
        int prevHeight = 0;
        int prevX = 0;
        for (int[] height : heights) {
            if (height[1] < 0) {
                heap.offer(-height[1]);
            } else {
                heap.remove(height[1]);
            }
            int curHeight = heap.peek();
            if (prevHeight != curHeight) {
                if (prevHeight != 0) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(prevX);
                    tmp.add(height[0]);
                    tmp.add(prevHeight);
                    rst.add(tmp);
                }
                prevHeight = curHeight;
                prevX = height[0];
            }
        }
        return rst;
    }
}