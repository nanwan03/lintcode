/**
 * Definition of Column:
 * public class Column {
 *     public int key;
 *     public String value;
 *     public Column(int key, String value) {
 *         this.key = key;
 *         this.value = value;
 *    }
 * }
 */


public class MiniCassandra {
    private Map<String, TreeMap<Integer, String>> hash;
    public MiniCassandra() {
        // do intialization if necessary
        hash = new HashMap<String, TreeMap<Integer, String>>();
    }

    /*
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
     */
    public void insert(String raw_key, int column_key, String column_value) {
        // write your code here
        if (!hash.containsKey(raw_key)) {
            hash.put(raw_key, new TreeMap<Integer, String>());
        }
        hash.get(raw_key).put(column_key, column_value);
    }

    /*
     * @param raw_key: a string
     * @param column_start: An integer
     * @param column_end: An integer
     * @return: a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end) {
        // write your code here
        List<Column> rst = new ArrayList<Column>();
        if (!hash.containsKey(raw_key)) {
            return rst;
        }
        for (Map.Entry<Integer, String> entry : 
                hash.get(raw_key).subMap(column_start, true, column_end, true).entrySet()) {
            rst.add(new Column(entry.getKey(), entry.getValue()));
        }
        return rst;
    }
}