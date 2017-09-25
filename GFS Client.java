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
    private int chunkSize;
    private Map<String, Integer> map = new HashMap<String, Integer>();
    /*
    * @param chunkSize: An integer
    */public GFSClient(int chunkSize) {
        // do intialization if necessary
        this.chunkSize = chunkSize;
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.get(filename); ++i) {
            sb.append(readChunk(filename, i));
        }
        return sb.toString();
    }

    /*
     * @param filename: a file name
     * @param content: a string
     * @return: nothing
     */
    public void write(String filename, String content) {
        // write your code here
        int size = (content.length() - 1) / chunkSize + 1;
        map.put(filename, size);
        for (int i = 0; i < size; ++i) {
            writeChunk(filename, i, content.substring(i * chunkSize, Math.min(content.length(), (i + 1) * chunkSize)));
        }
    }
}