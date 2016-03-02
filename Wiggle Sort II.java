public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0) return;

        double median = findMedian(nums);
        int firstHalfLen, secondHalfLen;
        if(nums.length % 2 == 0) {
            firstHalfLen = nums.length/2;
        } else {
            firstHalfLen = nums.length/2+1;
        }
        secondHalfLen = nums.length/2;
    
        List<Integer> firstHalf  = new ArrayList<Integer>();
        List<Integer> secondHalf = new ArrayList<Integer>();
    
        for(int i = 0; i < nums.length; i++) {
            if((double) nums[i] < median) firstHalf.add(nums[i]);
            else if((double) nums[i] > median) secondHalf.add(nums[i]);
        }
    
        while(firstHalf.size() < firstHalfLen) {
            firstHalf.add((int) median);
        }
        while(secondHalf.size() < secondHalfLen) {
            secondHalf.add((int) median);
        }
    
        for(int i = 0; i < firstHalf.size(); i++) {
            nums[i*2] = firstHalf.get(firstHalf.size()-1-i);
        }
        for(int i = 0; i < secondHalf.size(); i++) {
            nums[i*2+1] = secondHalf.get(i);
        }
    }
    
    private double findMedian(int[] nums) {
        if(nums.length % 2 == 1) return (double) findKth(nums, 0, nums.length-1, nums.length/2);
        else return ( (double) findKth(nums, 0, nums.length-1, nums.length/2 - 1) + (double) findKth(nums, 0, nums.length-1, nums.length/2) ) / 2;
    }
    
    private int findKth(int[] nums, int low, int high, int k) {
        int pivot = nums[low];
        int lb = low, hb = high, pt = low+1;;
        while(pt <= hb) {
            if(nums[pt] < pivot) swap(nums, lb++, pt++);
            else if(nums[pt] > pivot) swap(nums, pt, hb--);
            else pt++;
        }
        if(k < lb) return findKth(nums, low, lb-1, k);
        else if(k > hb) return findKth(nums, hb+1, high, k);
        else return pivot;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
