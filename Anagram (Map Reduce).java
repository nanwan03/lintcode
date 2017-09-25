/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 */
public class Anagram {

    public static class Map {
        public void map(String key, String value,
                        OutputCollector<String, String> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, String value);
            for (String str : value.split("\\s+")) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                output.collect(new String(chars), str);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<String> values,
                           OutputCollector<String, List<String>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<String> value);
            List<String> rst = new ArrayList<String>();
            while (values.hasNext()) {
                rst.add(values.next());
            }
            output.collect(key, rst);
        }
    }
}
