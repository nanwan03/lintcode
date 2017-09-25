public class GeoHash {
    /*
     * @param geohash: geohash a base32 string
     * @return: latitude and longitude a location coordinate pair
     */
    private final String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
    public double[] decode(String geohash) {
        // write your code here
        int[] mask = {16, 8, 4, 2, 1};
        double[] lng = {-180, 180};
        double[] lat = {-90, 90};
        boolean flag = true;

        for (int i = 0; i < geohash.length(); ++i) {
            int val = base32.indexOf(geohash.charAt(i));
            for (int j = 0; j < 5; ++j) {
                if (flag) {
                    adjust(lng, val, mask[j]);
                } else {
                    adjust(lat, val, mask[j]);
                }
                flag ^= true;
            }
        }
        double[] location = {(lat[0] + lat[1]) / 2.0, (lng[0] + lng[1]) / 2.0};
        return location;
    }
    public void adjust(double[] interval, int val, int mask) {
        if ((val & mask) > 0) {
            interval[0] = (interval[0] + interval[1]) / 2.0;
        } else {
            interval[1] = (interval[0] + interval[1]) / 2.0;
        }
    }
}