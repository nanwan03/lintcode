public class TinyUrl2 {
    /*
     * @param long_url: a long url
     * @param key: a short key
     * @return: a short url starts with http://tiny.url/
     */
    private char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private final long L = chars.length;
    private final String tinyURL = "http://tiny.url/";
    private long globalID = 0;
    
    private Map<String, String> as2l = new HashMap<String, String>();
    private Map<String, String> al2s = new HashMap<String, String>();
    private Map<String, String> cs2l = new HashMap<String, String>();
    private Map<String, String> cl2s = new HashMap<String, String>();
    public String createCustom(String long_url, String key) {
        // write your code here
        String shortURL = tinyURL + key;
        if (cs2l.containsKey(shortURL) && !cs2l.get(shortURL).equals(long_url)) {
            return "error";
        } else if (cl2s.containsKey(long_url) && !cl2s.get(long_url).equals(shortURL)) {
            return "error";
        } else {
            cs2l.put(shortURL, long_url);
            cl2s.put(long_url, shortURL);
            return shortURL;
        }
    }

    /*
     * @param long_url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String long_url) {
        // write your code here
        if (cl2s.containsKey(long_url)) {
            return cl2s.get(long_url);
        } else if (al2s.containsKey(long_url)) {
            return al2s.get(long_url);
        } else {
            String shortURL = tinyURL + idToKey(++globalID);
            as2l.put(shortURL, long_url);
            al2s.put(long_url, shortURL);
            return shortURL;
        }
    }

    /*
     * @param short_url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String short_url) {
        // write your code here
        if (cs2l.containsKey(short_url)) {
            return cs2l.get(short_url);
        } else {
            return as2l.get(short_url);
        }
    }

    private String idToKey(long n) {
        StringBuilder shortKey = new StringBuilder();
        while (n > 0) {
            shortKey.append(chars[(int)(n % L)]);
            n = n / L;
        }
        while (shortKey.length() < 6) {
            shortKey.append(chars[0]);
        }
        return shortKey.reverse().toString();
    }
}