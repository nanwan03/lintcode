/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
class Pair implements Comparable<Pair> {
    String key;
    int value;
    Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }
    public int compareTo(Pair a) {
        return this.value == a.value ? a.key.compareTo(this.key) : this.value - a.value;
    }
}
public class TopKFrequentWords {

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            for (String word : value.content.split("\\s+"))
                if (word.length() > 0) {
                    output.collect(word, 1);
                }
        }
    }

    public static class Reduce {
        private Queue<Pair> heap = new PriorityQueue<Pair>();
        private int k;
        public void setup(int k) {
            // initialize your data structure here
            this.k = k;
        }   

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next();
            }
            Pair pair = new Pair(key, sum);
            if (heap.size() < k) {
                heap.offer(pair);
            } else {
                if (pair.compareTo(heap.peek()) > 0) {
                    heap.poll();
                    heap.add(pair);
                }
            }
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            List<Pair> pairs = new ArrayList<Pair>();
            while (!heap.isEmpty()) {
                pairs.add(heap.poll());
            }
            for (int i = pairs.size() - 1; i >= 0; --i) {
                output.collect(pairs.get(i).key, pairs.get(i).value);
            }
        }
    }
}