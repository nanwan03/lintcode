class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
       if (i == 0 && j == 31) {
    	   return m;
       }
       if (m == 0) {
    	   for (int k = i; k <= j; k++) {
    		   n = n & ~(1 << k);
    	   }
    	   return n;
       }
       if (i == 0 && j == 31) {
           return m;
       }
        int max = ~0; /* All 1¡¯s */ 

        // 1¡¯s through position j, then 0¡¯s 
        int left = max - ((1 << (j+1)) - 1); // here should be j+1 not j. 
        
        // 1¡¯s after position i 
        int right = ((1 << i) - 1); 
        
        // 1¡¯s, with 0s between i and j 
        int mask = left | right; 
        
        // Clear i through j, then put m in there 
        return (n & mask) | (m << i); 
    }
}

