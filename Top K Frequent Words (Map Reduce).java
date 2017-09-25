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
public class TopKFrequentWords {
    public static class Pair implements Comparable<Pair> {
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
    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            for (String str : value.content.split("\\s+")) {
                output.collect(str, 1);
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
            int freq = 0;
            while (values.hasNext()) {
                freq += values.next();
            }
            Pair p = new Pair(key, freq);
            if (heap.size() < k) {
                heap.offer(p);
            } else if (p.compareTo(heap.peek()) > 0) {
                heap.poll();
                heap.offer(p);
            }
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            List<Pair> list = new ArrayList<Pair>();
            while (!heap.isEmpty()) {
                list.add(heap.poll());
            }
            for (int i = list.size() - 1; i >= 0; --i) {
                Pair p = list.get(i);
                output.collect(p.key, p.value);
            }
        }
    }
}