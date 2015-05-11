import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int closet = Integer.MAX_VALUE / 2;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == target) {
                    return target;
                } else {
                    closet = Math.abs(sum - target) < Math.abs(closet - target) ? sum : closet;
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return closet;
    }
}

