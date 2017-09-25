/* Definition of BaseGFSClient
 * class BaseGFSClient {
 *     private Map<String, String> chunk_list;
 *     public BaseGFSClient() {}
 *     public String readChunk(String filename, int chunkIndex) {
 *         // Read a chunk from GFS
 *     }
 *     public void writeChunk(String filename, int chunkIndex,
 *                            String content) {
 *         // Write a chunk to GFS
 *     }
 * }
 */


public class GFSClient extends BaseGFSClient {
    /*
    * @param chunkSize: An integer
    */
    public int chunkSize;
    public Map<String, Integer> map;
    public GFSClient(int chunkSize) {
        // do intialization if necessary
        this.chunkSize = chunkSize;
        this.map = new HashMap<String, Integer>();
    }

    /*
     * @param filename: a file name
     * @return: conetent of the file given from GFS
     */
    public String read(String filename) {
        // write your code here
        if (!map.containsKey(filename)) {
            return null;
        }
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < map.get(filename); ++i) {
            content.append(readChunk(filename, i));
        }
        return content.toString();
    }

    /*
     * @param filename: a file name
     * @param content: a string
     * @return: nothing
     */
    public void write(String filename, String content) {
        // write your code here
        int length = content.length();
        int num = (length - 1) / chunkSize + 1;
        map.put(filename, num);
        for (int i = 0; i < num; ++i) {
            int start = i * chunkSize;
            int end = Math.min(length, (i + 1) * chunkSize); 
            writeChunk(filename, i, content.substring(start, end));
        }
    }
}