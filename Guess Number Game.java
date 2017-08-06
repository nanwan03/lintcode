/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        // Write your code here
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int flag = guess(mid);
            if (flag == 0) {
                return mid;
            } else if (flag == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return guess(left) == 0 ? left : right;
    }
}