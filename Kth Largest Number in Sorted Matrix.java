public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
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
		// this method needs to be overridden to be used by HashSet.
		// we need to guarantee two things:
		// 1). for any equal Entry objects, their hashCode should be same.
		// 2). provide as less conflicts as possible for not equal objects.
		@Override
		public int hashCode() {
			return xIndex * 101 + yIndex;
		}
		
		// this method needs to be overridden to be used by HashSet.
		// if two Entry objects have the same xIndex and yIndex,
		// we think them equal.
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
        return b.value - a.value;
      }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || k == 0) {
		  return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		Queue<Entry> minHeap = new PriorityQueue<Entry>(matrix.length * matrix[0].length, new EntryComparator());
		Set<Entry> visited = new HashSet<Entry>();
		Set<Integer> set = new HashSet<Integer>();
		
		Entry start = new Entry(row - 1, col - 1, matrix[row - 1][col - 1]);
		minHeap.offer(start);
		visited.add(start);
		int result = matrix[row - 1][col - 1];
		set.add(matrix[row - 1][col - 1]);
		k--;
		while (k > 0) {
			Entry current = minHeap.poll();
            result = current.value;
            if (set.add(result)) {
            	k--;
            }
			if (current.xIndex - 1 >= 0) {
				Entry top = new Entry(current.xIndex - 1, current.yIndex,
						matrix[current.xIndex - 1][current.yIndex]);
				if (!visited.contains(top)) {
					minHeap.offer(top);
					visited.add(top);
				}
			}
			if (current.yIndex - 1 >= 0) {
				Entry left = new Entry(current.xIndex, current.yIndex - 1,
						matrix[current.xIndex][current.yIndex - 1]);
				if (!visited.contains(left)) {
					minHeap.offer(left);
					visited.add(left);
				}
			}
		}
		return result;
    }
}
