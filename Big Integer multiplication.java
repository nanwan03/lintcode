public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        // Write your code here
        if(num1.equals("0") || num2.equals("0")){  
            return "0";  
        }  
        int len1 = num1.length();  
        int len2 = num2.length();  
        char[] result = new char[len1+len2];  
        for(int k = 0;k<result.length;k++){  
            result[k] = '0';  
        }  
          
        for(int i = len1 - 1;i>=0;i--){  
            int p = 0;  
            for(int j = len2 - 1;j>=0;j--){  
                int temp = (result[i + j + 1] - '0') + (num1.charAt(i) - '0')*(num2.charAt(j) - '0') + p;  
                p = temp/10;  
                result[i + j + 1] = (char)(temp%10 + '0');  
            }  
            result[i] += p;  
        }  
          
        String res = "";  
        int count = 0;  
        for(;count<result.length;count++){  
            if(result[count]!='0'){  
                break;  
            }  
        }  
        for(int i = count;i<result.length;i++){  
            res += result[i];  
        }  
        return res;  
    }
}