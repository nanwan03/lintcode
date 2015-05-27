public class Solution {
	/**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public boolean isNumber(String s) {
        //trim whitespace front and end
        s = s.trim();

        if (s.length()<1) { //if no digits
            return false; 
        }


        if (s.charAt(s.length()-1) == 'f' || s.charAt(s.length()-1) == 'D'){ //last digit check
            return false;   //if last digit is f or D, fail
        }

        try{
            Double.parseDouble(s);   //parse as a double
            return true;

        } catch (NumberFormatException e){
            return false;
        }
    }
}