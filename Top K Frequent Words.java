public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    class Node {
        String str;
        int freq;
        Node(String str, int freq) {
          this.str = str;
          this.freq = freq;
    }
  }
  class NodeComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
    	if (a.freq == b.freq) {
    		return a.str.compareTo(b.str);
    	}
    	return b.freq - a.freq;
    }
  }
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        String[] rst = new String[k];
        if (words == null || words.length == 0 || k == 0) {
          return rst;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : words) {
          if (!map.containsKey(str)) {
            map.put(str, 1);
          } else {
            map.put(str, map.get(str) + 1);
          }
        }
        Queue<Node> heap = new PriorityQueue<Node>(words.length, new NodeComparator());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
          String key = entry.getKey();
          int value = entry.getValue();
          heap.offer(new Node(key, value));
        }
        int index = 0;
        while (index != k) {
          rst[index++] = heap.poll().str;
        }
        return rst;
    }
}