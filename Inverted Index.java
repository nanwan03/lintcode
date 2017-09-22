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
        Map<String, List<Integer>> results = new HashMap<String, List<Integer>>();
        for (Document doc : docs) {
            int id = doc.id;
            StringBuffer temp = new StringBuffer("");
            String content = doc.content;
            int n = content.length();
            for (int i = 0; i < n; ++i) {
                if (content.charAt(i) == ' ') {
                    insert(results, temp.toString(), id);
                    temp = new StringBuffer("");
                } else
                    temp.append(content.charAt(i));
            }
            insert(results, temp.toString(), id);
        }
        return results;
    }
    private void insert(Map<String, List<Integer>> rt, String tmp, int id) {
        if (tmp.equals("") || tmp == null)
            return;
        if (!rt.containsKey(tmp))
            rt.put(tmp, new ArrayList<Integer>());
        
        int n = rt.get(tmp).size();
        if (n == 0 || rt.get(tmp).get(n - 1) != id)
            rt.get(tmp).add(id);
    }
}