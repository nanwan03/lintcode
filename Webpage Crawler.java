/**
 * public class HtmlHelper {
 *     public static List<String> parseUrls(String url);
 *         // Get all urls from a webpage of given url. 
 * }
*/
import java.lang.Thread;
import java.net.*;
import java.util.concurrent.*;

class CrawlerThread extends Thread {
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
    private static Set<String> set = new HashSet<String>();
    public static void setFirstUrl(String url) {
        try {
            queue.put(url);
        } catch (InterruptedException e) {
            // e.printStackTrace(); 
        }
    }
    public static List<String> getResults() {
        return new ArrayList<String>(set);
    }
    @Override
    public void run() {
        while (true) {
            try {
                String url = queue.take();
                URL netUrl = new URL(url);
                String domain = netUrl.getHost();
                if (domain.endsWith("wikipedia.org") && set.add(url)) {
                    List<String> urls = HtmlHelper.parseUrls(url);
                    for (String next : urls) {
                        queue.put(next);
                    }
                }
            } catch (Exception e) {
                break;
            }
        }
    }
}

public class Solution {
    /**
     * @param url a url of root page
     * @return all urls
     */
    private static final int THREAD = 3;
    public List<String> crawler(String url) {
        // Write your code here
        CrawlerThread.setFirstUrl(url);
        CrawlerThread[] threadPools = new CrawlerThread[THREAD];
        for (int i = 0; i < THREAD; ++i) {
            threadPools[i] = new CrawlerThread();
            threadPools[i].start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            // e.printStackTrace();
        }
        for (int i = 0; i < THREAD; ++i) {
            //thread_pools[i].interrupt();
            threadPools[i].interrupt();
        }
        return CrawlerThread.getResults();
    }
}
