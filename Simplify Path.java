public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        // Write your code here
        if (path == null || path.length() == 0) {
            return "";
        }
        String[] subs = path.split("/+");
        List<String> paths = new ArrayList<String>();
        for (String str : subs) {
            if (str.equals("..")) {
                if (paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                }
            } else if (!str.equals("") && !str.equals(".")) {
                paths.add(str);
            }
        }
        if (paths.size() == 0) {
            return "/";
        } else {
            String rst = "";
            for (String str : paths) {
                rst += "/" + str;
            }
            return rst;
        }
    }
}
