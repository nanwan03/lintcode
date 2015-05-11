class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      */
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            return "";
        }
        k--;
        boolean[] visited = new boolean[n];
        int factor = 1;
        for (int i = 1; i < n; i++) {
            factor *= i;
        }
        for (int i = 0; i < n; i++) {
            int index = k / factor;
            k %= factor;
            if (i < n - 1) {
                factor /= n - 1 - i;
            }
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    if (index == 0) {
                        sb.append(j + 1);
                        visited[j] = true;
                        break;
                    } else {
                        index--;
                    }
                }
            }
        }
        return sb.toString();
    }
}

