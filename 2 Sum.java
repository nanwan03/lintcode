public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] rst = new int[2];
        if (numbers == null) {
            return rst;
        }
        for (int i = 1; i <= numbers.length; i++) {
            for (int j = i + 1; j <= numbers.length; j++) {
                if (numbers[i - 1] + numbers[j - 1] == target) {
                    rst[0] = i;
                    rst[1] = j;
                    return rst;
                }
            }
        }
        return rst;
    }
}
