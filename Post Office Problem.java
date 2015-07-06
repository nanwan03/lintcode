public class Solution {
    /**
     * @param A an integer array
     * @param k an integer
     * @return an integer
     */
    public int postOffice(int[] A, int k) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int villageNum = A.length;
        int postNum = k;
        if (postNum >= villageNum) {
            return 0;
        }
        int[][] dp = new int[villageNum][postNum];
		int[][] dis = new int[villageNum][villageNum];
		Arrays.sort(A);
		init(dis, A);
		for (int i = 0; i < villageNum; ++i) {
			Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
		}
		for (int i = 0; i < villageNum; ++i) {
			dp[i][0] = dis[0][i];
		}
		for (int l = 1; l < postNum; ++l) {
			for (int i = 0; i < villageNum; ++i) {
				for (int j = 0; j < i; ++j) {
					if (dp[j][l - 1] + dis[j + 1][i] < dp[i][l]) {
						dp[i][l] = dp[j][l - 1] + dis[j + 1][i];
					}
				}
			}
		}
		return dp[villageNum - 1][postNum - 1];
    }
    private static void init(int[][] dis, int[] input) {
		for (int i = 0; i < dis.length - 1; ++i) {
			for (int j = i + 1; j < dis.length; ++j) {
				int mid = (i + j) / 2;
				for (int k = i; k < mid; ++k) {
					dis[i][j] += input[mid] - input[k];
				}
				for (int k = mid + 1; k <= j; ++k) {
					dis[i][j] += input[k] - input[mid];
				}
			}
		}
	}
}
