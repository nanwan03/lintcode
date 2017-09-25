public class GeoHash {
    /*
     * @param geohash: geohash a base32 string
     * @return: latitude and longitude a location coordinate pair
     */
    private final String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
    private int[] mask = new int[]{16, 8, 4, 2, 1};
    public double[] decode(String geohash) {
        // write your code here
        double[] lng = new double[]{-180, 180};
        double[] lat = new double[]{-90, 90};
        boolean flag = true;
        for (char c : geohash.toCharArray()) {
            int val = base32.indexOf(c);
            for (int j = 0; j < mask.length; ++j) {
                if (flag) {
                    adjust(lng, val & mask[j]);
                } else {
                    adjust(lat, val & mask[j]);
                }
                flag ^= true;
            }
        }
        return new double[]{(lat[0] + lat[1]) / 2.0, (lng[0] + lng[1]) / 2.0};
    }
    private void adjust(double[] d, int mask) {
        if (mask > 0) {
            d[0] = (d[0] + d[1]) / 2.0;
        } else {
            d[1] = (d[0] + d[1]) / 2.0;
        }
    }
}