public class GeoHash {
    /*
     * @param latitude: one of a location coordinate pair 
     * @param longitude: one of a location coordinate pair 
     * @param precision: an integer between 1 to 12
     * @return: a base32 string
     */
    private final String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
    private final int L = 60;
    public String encode(double latitude, double longitude, int precision) {
        // write your code here
        String lngBin = getBin(longitude, -180, 180);
        String latBin = getBin(latitude, -90, 90);
        StringBuilder combine = new StringBuilder();
        for (int i = 0; i < L / 2; ++i) {
            combine.append(lngBin.charAt(i));
            combine.append(latBin.charAt(i));
        }
        StringBuilder hashCode = new StringBuilder();
        for (int i = 0; i < L; i += 5) {
            int index = Integer.parseInt(combine.substring(i, i + 5), 2);
            hashCode.append(base32.charAt(index));
        }
        return hashCode.substring(0, precision);
    }
    private String getBin(double value, double left, double right) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < L / 2; ++i) {
            double mid = (left + right) / 2;
            if (value > mid) {
                left = mid;
                sb.append("1");
            } else {
                right = mid;
                sb.append("0");
            }
        }
        return sb.toString();
    }
}