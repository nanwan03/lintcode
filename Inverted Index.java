/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class Solution {
    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (Document doc : docs) {
            int id = doc.id;
            String[] strs = doc.content.split("\\s+");
            for (String str : strs) {
                if (!map.containsKey(str)) {
                    map.put(str, new ArrayList<Integer>());
                }
                int size = map.get(str).size();
                if (size == 0 || map.get(str).get(size - 1) != id) {
                    map.get(str).add(id);
                }
            }
        }
        return map;
    }
}