public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        int[] rst = new int[numCourses];
        if (numCourses == 0 || prerequisites == null) {
            return rst;
        }
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            adjList.add(new ArrayList<Integer>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            rst[index++] = n;
            for (int next : adjList.get(n)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (index == numCourses) {
            return rst;
        }
        return new int[0];
    }
}