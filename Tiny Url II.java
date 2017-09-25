public class TinyUrl2 {
    /*
     * @param long_url: a long url
     * @param key: a short key
     * @return: a short url starts with http://tiny.url/
     */
    private static char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private static final long L = chars.length;
    private final String tinyURL = "http://tiny.url/";
    private static long globalID = 0;
    
    private Map<Long, String> id2url = new HashMap<Long, String>();
    private Map<String, Long> url2id = new HashMap<String, Long>();
    private Map<String, String> s2l = new HashMap<String, String>();
    private Map<String, String> l2s = new HashMap<String, String>();
    public String createCustom(String long_url, String key) {
        // write your code here
        String shortURL = tinyURL + key;
        if (s2l.containsKey(shortURL) && !s2l.get(shortURL).equals(long_url)) {
            return "error";
        } else if (l2s.containsKey(long_url) && !l2s.get(long_url).equals(shortURL)) {
            return "error";
        } else {
            s2l.put(shortURL, long_url);
            l2s.put(long_url, shortURL);
            return shortURL;
        }
    }

    /*
     * @param long_url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String long_url) {
        // write your code here
        if (l2s.containsKey(long_url)) {
            return l2s.get(long_url);
        } else if (url2id.containsKey(long_url)) {
            return tinyURL + idToKey(url2id.get(long_url));
        } else {
            String key = idToKey(++globalID);
            id2url.put(globalID, long_url);
            url2id.put(long_url, globalID);
            return tinyURL + key;
        }
    }

    /*
     * @param short_url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String short_url) {
        // write your code here
        if (s2l.containsKey(short_url)) {
            return s2l.get(short_url);
        } else {
            long id = keyToId(short_url.substring(tinyURL.length()));
            return id2url.get(id);
        }
    }

    private int toBase62(char c) {
        if ('a' <= c && c <= 'z') {
            return c - 'a';
        } else if ('A' <= c && c <= 'Z') {
            return c - 'A' + 26;
        } else {
            return c - '0' + 52;
        }
    }
    
    private long keyToId(String shortKey) {
        long id = 0;
        for (int i = 0; i < shortKey.length(); ++i) {
            id = id * L + toBase62(shortKey.charAt(i));
        }
        return id;
    }

    private String idToKey(long n) {
        StringBuilder shortKey = new StringBuilder();
        while (n > 0) {
            shortKey.append(chars[(int)(n % L)]);
            n = n / L;
        }
        while (shortKey.length() < 6) {
            shortKey.append("a");
        }
        return shortKey.reverse().toString();
    }
}