/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return node;
        }
        Queue<UndirectedGraphNode> nodes = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        nodes.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while (!nodes.isEmpty()) {
            //int size = nodes.size();
            //for (int i = 0; i < size; i++) {
                UndirectedGraphNode oldNode = nodes.poll();
                UndirectedGraphNode newNode = map.get(oldNode);
                for (int j = 0; j < oldNode.neighbors.size(); j++) {
                    UndirectedGraphNode neighbor = oldNode.neighbors.get(j);
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                        nodes.offer(neighbor);
                    }
                    newNode.neighbors.add(map.get(neighbor));
                }
           // }
        }
        return map.get(node);
    }
}
