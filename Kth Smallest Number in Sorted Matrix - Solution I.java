public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     * MLE
     */
    private static class Entry {
		int xIndex;
		int yIndex;
		int value;
		
		public Entry(int xIndex, int yIndex, int value) {
			this.xIndex = xIndex;
			this.yIndex = yIndex;
			this.value = value;
		}
		@Override
		public int hashCode() {
			return xIndex * 101 + yIndex;
		}
		
		@Override
		public boolean equals(Object obj) {
		  if (obj == null || !(obj instanceof Entry)) {
		    return false;
		  }
		  if (obj == this) {
		    return true;
		  }
		  Entry entry = (Entry)obj;
		  return entry.xIndex == this.xIndex && entry.yIndex == this.yIndex;
		}
	}

    private class EntryComparator implements Comparator<Entry> {
      public int compare(Entry a, Entry b) {
        return a.value - b.value == 0 ? a.hashCode() - b.hashCode() : a.value - b.value;
      }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || k == 0) {
		  return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] visited = new boolean[row][col];
		TreeSet<Entry> minHeap = new TreeSet<Entry>(new EntryComparator());
		
		Entry start = new Entry(0, 0, matrix[0][0]);
		minHeap.add(start);
		int result = matrix[0][0];
		visited[0][0] = true;
		
		while (k > 0) {
			Entry current = minHeap.pollFirst();
            result = current.value;
            k--;
			if (current.xIndex + 1 < row) {
				Entry top = new Entry(current.xIndex + 1, current.yIndex, matrix[current.xIndex + 1][current.yIndex]);
				if (!visited[current.xIndex + 1][current.yIndex]) {
					visited[current.xIndex + 1][current.yIndex] = true;
					minHeap.add(top);
				}
			}
			if (current.yIndex + 1 < col) {
				Entry left = new Entry(current.xIndex, current.yIndex + 1, matrix[current.xIndex][current.yIndex + 1]);
				if (!visited[current.xIndex][current.yIndex + 1]) {
					visited[current.xIndex][current.yIndex + 1] = true;
					minHeap.add(left);
				}
			}
		}
		return result;
    }
}
