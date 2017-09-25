public class Solution {
    /*
     * @param timestamp: the current timestamp
     * @param event: the string to distinct different event
     * @param rate: the format is [integer]/[s/m/h/d]
     * @param increment: whether we should increase the counter
     * @return: true or false to indicate the event is limited or not
     */
    private Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    private Map<String, Integer> durationMap = new HashMap<String, Integer>();
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        // write your code here
        durationMap.put("s", 1);
        durationMap.put("m", 60);
        durationMap.put("h", 3600);
        durationMap.put("d", 86400);
        
        int start = rate.indexOf("/");
        int limit = Integer.parseInt(rate.substring(0, start));
        String type = rate.substring(start + 1, rate.length());
        int duration = durationMap.get(type);
        int startTimestamp = timestamp - duration + 1;
        if (!map.containsKey(event)) {
            map.put(event, new ArrayList<Integer>());
        }
        int count = getCount(map.get(event), startTimestamp);
        boolean flag = count >= limit;
        if (increment && !flag) {
            map.get(event).add(timestamp);
        }
        return flag;
    }
    
    public int getCount(List<Integer> event, int target) {
        int left = 0;
        int right = event.size() - 1;
        if (left > right || event.get(right) < target) {
            return 0;
        }
        int index = 0;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (event.get(mid) >= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return event.size() - index;
    }
}