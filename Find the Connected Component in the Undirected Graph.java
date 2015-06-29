/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nodes == null || nodes.size() == 0) {
            return rst;
        }
        Set<Integer> set = new HashSet<Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        for (UndirectedGraphNode node : nodes) {
            if (set.add(node.label)) {
                queue.clear();
                List<Integer> items = new ArrayList<Integer>();
                items.add(node.label);
                queue.offer(node);
                while (!queue.isEmpty()) {
                   UndirectedGraphNode tempNode = queue.poll();
                   for (UndirectedGraphNode neighbor : tempNode.neighbors) {
                       if (set.add(neighbor.label)) {
                           queue.offer(neighbor);
                           items.add(neighbor.label);
                       }
                   }
                }
                Collections.sort(items);
                rst.add(new ArrayList<Integer>(items));
            }
        }
        return rst;
    }
}
