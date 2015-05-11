import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: Find a  majority number that is the number that occurs more than 1/3 of the size of the array
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int candidate1 = 0;
        int count1 = 0;
        int candidate2 = 0;
        int count2 = 0;
        for (int i : nums) {
            if  (candidate1 == i) {
                count1++;
            } else if (candidate2 == i) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = i;
                count1++;
            } else if(count2 == 0) {
                candidate2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (candidate1 == i) {
                count1++;
            } else if (candidate2 == i) {
                count2++;
            }
        }
        return count1 > count2 ? candidate1 : candidate2;
    }
}

