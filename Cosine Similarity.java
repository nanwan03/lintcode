public class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        double crossProduct = 0;
		double squareSumA = 0;
		double squareSumB = 0;
		for (int i = 0; i < A.length; ++i) {
			crossProduct += (double)(A[i] * B[i]);
			squareSumA += (double)(A[i] * A[i]);
			squareSumB += (double)(B[i] * B[i]);
		}
		if (squareSumA == 0.0 || squareSumB == 0.0) {
			String str = String.format("%.4f", 2.0000);
			return Double.parseDouble(str);
		}
		Double rst = (crossProduct / (Math.sqrt(squareSumA) * Math.sqrt(squareSumB)));
		String str = String.format("%.4f", rst);
		return Double.parseDouble(str);
    }
}

