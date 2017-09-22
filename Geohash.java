public class GeoHash {
    /*
     * @param latitude: one of a location coordinate pair 
     * @param longitude: one of a location coordinate pair 
     * @param precision: an integer between 1 to 12
     * @return: a base32 string
     */
    
    public String encode(double latitude, double longitude, int precision) {
        // write your code here
        String _base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        String lat_bin = getBin(latitude, -90, 90);
        String lng_bin = getBin(longitude, -180, 180);
        
        StringBuffer hash_code = new StringBuffer();
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < 30; ++i) {
            b.append(lng_bin.charAt(i));
            b.append(lat_bin.charAt(i));
        }

        for (int i = 0; i < 60; i += 5) {
            int index = b2i(b.substring(i, i + 5));
            hash_code.append(_base32.charAt(index));
        }
        return hash_code.substring(0, precision);
    }
    public int b2i(String bin) {
        return Integer.parseInt(bin, 2);
    }

    public String getBin(double value, double left, double right) {
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < 30; ++i) {
            double mid = (left + right) / 2.0;
            if (value > mid) {
                left = mid;
                b.append("1");
            } else {
                right = mid;
                b.append("0");
            }
        }
        return b.toString();
    }
}